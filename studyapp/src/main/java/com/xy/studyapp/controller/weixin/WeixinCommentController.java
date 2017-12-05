package com.xy.studyapp.controller.weixin;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.weixin.WeixinComment;
import com.xy.studyapp.service.weixin.WeixinCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * create by xy on 2017/12/5
 */
@Api(description = "小程序评论接口,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/wx/comment")
public class WeixinCommentController {
    @Autowired
    private WeixinCommentService weixinCommentService;
    Logger logger=Logger.getLogger(WeixinCommentController.class);

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增评论", notes = "")
    BaseResp add(@RequestBody WeixinComment comment){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>新增评论：answer:"+comment.toString());
        comment.setDefault();
        try {
            weixinCommentService.add(comment);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add comment faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
