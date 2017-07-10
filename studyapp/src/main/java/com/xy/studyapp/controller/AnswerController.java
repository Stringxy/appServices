package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.service.AnswerService;
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
@Api(description = "问题回复管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    Logger logger=Logger.getLogger(AnswerController.class);

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增提问--问题回复", notes = "")
    BaseResp add(@RequestBody Answer answer){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>提问新增：answer:"+answer.toString());
        answer.setDefault();
        try {
            boolean bool=answerService.add(answer);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add answer faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "全查询提问--问题回复", notes = "")
    BaseResp home() {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>问题回复全查询");
        try {
            List<Answer> answers=answerService.findAll();
            BaseResp.setResp(true,baseResp);
            if(answers==null||answers.size()<1){
                baseResp.setResultNote("当前没有记录。");
            }else {
                baseResp.setDetail(answers);
            }
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  问题回复查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
