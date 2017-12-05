package com.xy.studyapp.controller.weixin;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.weixin.TopicVo;
import com.xy.studyapp.entity.weixin.WeixinTopic;
import com.xy.studyapp.service.weixin.WeixinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * create by xy on 2017/12/2
 */
@Api(description = "小程序接口,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/weixin")
public class WeixinController {
    @Autowired
    WeixinService weixinService;
    Logger logger=Logger.getLogger(WeixinController.class);

    @RequestMapping(value = "/addNote",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增笔记", notes = "")
    BaseResp add(@RequestBody WeixinTopic note){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>wx新增笔记："+note.toString());
        try {
            boolean bool=weixinService.add(note);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add note faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取最新笔记", notes = "")
    BaseResp findNew(@RequestBody TopicVo vo) {
        BaseResp baseResp=new BaseResp();
        try {
            if(vo.getPageNo()==null){
                vo=new TopicVo(0,10);
            }
            Page<WeixinTopic> notePage=weixinService.getTopics(vo);
            BaseResp.setResp(true,baseResp);
            //Map<String,Object> detail=new HashMap<String,Object>();
            baseResp.setDetail(notePage.getContent());
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id查询笔记", notes = "")
    BaseResp findTopicById(@PathVariable String id){
        BaseResp baseResp=new BaseResp();
        try {
            WeixinTopic topic=weixinService.getTopicById(id);
            BaseResp.setResp(true,baseResp);
            Map<String,Object> detail=new HashMap<String,Object>();
            baseResp.setDetail(topic);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }


    @RequestMapping(value = "/userTopic",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取用户笔记", notes = "")
    BaseResp findByOpenid(@RequestBody TopicVo vo) {
        BaseResp baseResp=new BaseResp();
        try {
            if(vo.getPageNo()==null){
                vo=new TopicVo(0,10);
            }
            Page<WeixinTopic> notePage=weixinService.getTopicByOpenid(vo);
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(notePage.getContent());
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

}
