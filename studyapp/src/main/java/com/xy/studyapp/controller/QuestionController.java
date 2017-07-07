package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Api(description = "提问管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    Logger logger=Logger.getLogger(QuestionController.class);

    @RequestMapping("/findAll")
    @ResponseBody
    @ApiOperation(value = "提问全查询", notes = "")
    BaseResp home() {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>提问全查询");
        try {
            List<Question> questions=questionService.findAll();
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(questions);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  提问查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "提问新增", notes = "")
    BaseResp add(@RequestBody Question question){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>提问新增：ques:"+question.toString());
        question.setDefault();
        try {
            boolean bool=questionService.insert(question);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add ques faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
