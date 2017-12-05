package com.xy.studyapp.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.xy.studyapp.common.constant.ErrCode;
import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.entity.weixin.WeixinUser;
import com.xy.studyapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
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

    @RequestMapping(value = "/findById/{name}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "账号查询", notes = "")
    BaseResp home(@PathVariable String name) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>账号查询：id:"+name);
        try {

            User user=userService.findByNickName(name);
            BaseResp.setResp(true,baseResp);
            if(user==null){
                baseResp.setResultNote("当前没有记录。");
            }else {
                baseResp.setDetail(user);
            }
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  findUser faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "账号登陆", notes = "")
    BaseResp login(@RequestBody User user){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>账号登陆：username:"+user.getUserName()+"\tpassword:"+user.getPassword());
        try {
            user=userService.login(user.getUserName(),user.getPassword());
            if(user==null){
                baseResp.setResult(ErrCode.VALIDATE_FAILED);
                baseResp.setResultNote("用户名或密码错误！");
                return baseResp;
            }
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
            if(StringUtils.isEmpty(user.getNickName())||StringUtils.isEmpty(user.getPassword())||StringUtils.isEmpty(user.getUserName())){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("至少用户名，昵称，密码不为空！");
                return  baseResp;
            }
            User user1=userService.findByName(user.getUserName());
            if(user1!=null){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("用户名已被占用！");
                return  baseResp;
            }
            user1=userService.findByNickName(user.getNickName());
            if(user1!=null){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("昵称已被占用！");
                return  baseResp;
            }
            boolean bool=userService.insert(user);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add user faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }


    @RequestMapping(value = "/updatePortrait",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改头像", notes = "")
    BaseResp updateImg(@RequestBody User user){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>修改头像：user:"+user.toString());
        try {
            if(StringUtils.isEmpty(user.getId())||StringUtils.isEmpty(user.getPortrait())){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("请传入id，portrait！");
                return  baseResp;
            }
            boolean bool=userService.updateImage(user);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  update user faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "账号昵称个性签名修改", notes = "")
    BaseResp update(@RequestBody User user){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>账号昵称个性签名修改：user:"+user.toString());
        try {
            if(StringUtils.isEmpty(user.getId())){
                BaseResp.setResp(false,baseResp);
                baseResp.setResultNote("修改的用户ID不能为空！");
                return  baseResp;
            }

            boolean bool=userService.update(user);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  update user faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }


    @RequestMapping(value = "/loginByWeixin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "微信账号登陆", notes = "")
    BaseResp loginByWeixin(@RequestBody WeixinUser weixinUser){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>微信账号登陆小程序：user:"+weixinUser.toString());
        try{
            WeixinUser user=userService.loginByWeixin(weixinUser);
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(user);
            return baseResp;
        }catch (Exception e){
            logger.error("---->>  weixinuser login faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

}
