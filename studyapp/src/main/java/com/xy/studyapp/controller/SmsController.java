//package com.xy.studyapp.controller;
//
//import com.xy.studyapp.service.SMSService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by xy on 2017/6/26.
// */
//@RestController
//public class SmsController {
//    Logger logger=Logger.getLogger(SmsController.class);
//    @Autowired
//    private SMSService smsService;
//    @RequestMapping("/send")
//    public String sendSMS(String phone){
//
//        try {
//            return smsService.sendVarifyCode(phone);
//        } catch (Exception e) {
//            logger.error("发送短信异常：{}",e);
//            return "失败";
//        }
//    }
//}
