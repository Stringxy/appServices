package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.common.utils.*;
import com.xy.studyapp.common.utils.Base64;
import com.xy.studyapp.entity.base.BaseVo;
import com.xy.studyapp.entity.base.Comment;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.service.CommentService;
import com.xy.studyapp.service.NoteService;
import com.xy.studyapp.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by xy on 2017/7/7.
 */
@Api(description = "笔记管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private QuestionService questionService;
    Logger logger=Logger.getLogger(NoteController.class);

    @RequestMapping(value = "/findByUserId/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据userId查询笔记", notes = "")
    BaseResp home(@PathVariable String id) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>笔记查询：userId:"+id);
        try {
            List<Note> note=noteService.findByUserId(id);
            BaseResp.setResp(true,baseResp);
            if(note==null||note.size()<1){
                baseResp.setResultNote("当前没有记录。");
            }else {
                baseResp.setDetail(note);
            }
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增笔记", notes = "")
    BaseResp add(@RequestBody Note note){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>笔记新增：note:"+note.toString());
        note.setDefault();
        try {
            note.setType(0);
            if(StringUtils.isEmpty(note.getContent())||StringUtils.isEmpty(note.getTitle())){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("标题或内容不能为空！");
                return baseResp;
            }
            boolean bool=noteService.add(note);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add note faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }


    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id查询笔记", notes = "")
    BaseResp findOne(@PathVariable String id) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>笔记查询：id:"+id);
        try {
            Note note=noteService.findById(id);
            List<Comment> comments=commentService.findByNoteId(id);
            BaseResp.setResp(true,baseResp);
            Map<String,Object> detail=new HashMap<String,Object>();
            if(note==null){
                baseResp.setResultNote("当前没有记录。");
            }else {
                detail.put("note",note);
                detail.put("comment",comments);
            }
            baseResp.setDetail(detail);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取最新笔记", notes = "")
    BaseResp findNew(BaseVo baseVo) {
        BaseResp baseResp=new BaseResp();
        try {
            if(baseVo.getPageNo()==null){
                baseVo=new BaseVo(0,10);
            }
            Page<Note> notePage=noteService.findAll(baseVo.getPageNo(),baseVo.getPageSize(),SortUtil.basicSort());
            BaseResp.setResp(true,baseResp);
            Map<String,Object> detail=new HashMap<String,Object>();
            baseResp.setDetail(notePage.getContent());
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/updateImg",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传图片接口", notes = "")
    BaseResp updateImg(@RequestParam String img){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>笔记上传图片接口：img:"+img);
        try {
            if(StringUtils.isEmpty(img)){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("请传入参数！");
                return  baseResp;
            }
            //输出base64 数据,截取","之后的值进行转换
            String str = img.substring( img.indexOf(",")+1);
            //System.currentTimeMillis()意思是获取当前系统的时间戳给图片命名
            //实例化Base64转换类  调用里面的GenerateImage方法（把base64数据转为图片）
            //第一个参数base64转图片的必须的base64数据，第二个是转换后生成的图片存放路径
            long currentTime=System.currentTimeMillis();
            Base64.GenerateImage(str, "/usr/java/tomcat/apache-tomcat-8.5.16/webapps/img/"+currentTime+".jpg");
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(currentTime+".jpg");
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  updateImg note faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
