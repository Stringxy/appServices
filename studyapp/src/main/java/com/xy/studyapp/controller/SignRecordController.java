package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.entity.base.SignRecord;
import com.xy.studyapp.service.CommentService;
import com.xy.studyapp.service.SignRecordService;
import com.xy.studyapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xy on 2017/8/14.
 */
@Api(description = "签到管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/sign")
public class SignRecordController {
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private UserService userService;
    Logger logger=Logger.getLogger(SignRecordController.class);

    @RequestMapping(value = "/findByUser/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据会员查询当月签到", notes = "")
    BaseResp home(@PathVariable String id) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>根据会员查询");
        try {
            List<SignRecord> signRecords=signRecordService.findByUserId(id);
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(signRecords);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  根据会员查询签到记录异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/add/{id}",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "签到", notes = "")
    BaseResp add(@PathVariable String id){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>用户签到：id:"+id);
        try {
            SignRecord signRecord=new SignRecord();
            signRecord.setUserId(id);
            boolean bool=signRecordService.validate(signRecord);
            if(!bool){
                BaseResp.setResp(false,baseResp);
                return baseResp;
            }
            bool=signRecordService.insert(signRecord);
            BaseResp.setResp(bool,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  用户签到 faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
