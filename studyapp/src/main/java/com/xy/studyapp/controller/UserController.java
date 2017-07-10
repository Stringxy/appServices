package com.xy.studyapp.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.xy.studyapp.common.constant.ErrCode;
import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xy on 2017/6/23.
 */
@Api(description = "用户管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    Logger logger=Logger.getLogger(UserController.class);

    @RequestMapping(value = "/findByName/{name}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "账号查询（根据用户名）", notes = "")
    BaseResp home(@PathVariable String name) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>账号查询：username:"+name);
        try {
            User user=userService.findByName(name);
            BaseResp.setResp(true,baseResp);
            if(user==null){
                baseResp.setResultNote("当前没有记录。");
            }else {
                baseResp.setDetail(user);
            }
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  login faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "账号登陆", notes = "")
    BaseResp login(@RequestParam String username,@RequestParam  String password){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>账号登陆：username:"+username+"\tpassword:"+password);
        try {
            User user=userService.login(username,password);
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(user);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  login faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "账号新增", notes = "")
    BaseResp add(@RequestBody User user){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>账号新增：user:"+user.toString());
        try {
            boolean bool=userService.insert(user);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add user faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
