package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.base.Comment;
import com.xy.studyapp.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xy on 2017/7/23.
 */
@Api(description = "评论管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    Logger logger=Logger.getLogger(AnswerController.class);

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增评论", notes = "")
    BaseResp add(@RequestBody Comment comment){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>新增评论：answer:"+comment.toString());
        comment.setDefault();
        try {
            if(StringUtils.isEmpty(comment.getCommentUser())){
                BaseResp.setResp(true,baseResp);
                baseResp.setResultNote("请先登陆！");
                return baseResp;
            }
            if(StringUtils.isEmpty(comment.getNoteId())||StringUtils.isEmpty(comment.getContent())){
                BaseResp.setResp(true,baseResp);
                baseResp.setResultNote("回复的笔记id，回复的内容不能为空！");
                return baseResp;
            }
            boolean bool=commentService.add(comment);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add comment faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/my/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询用户评论", notes = "")
    BaseResp add(@PathVariable String id){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>查询用户评论：id:"+id);
        try {
            List<Comment> comment=commentService.findByUserId(id);
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(comment);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  get user's comment faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

}
