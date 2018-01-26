package com.xy.studyapp.controller;

import com.xy.studyapp.common.constant.ErrCode;
import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.security.Role;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.entity.weixin.WeixinUser;
import com.xy.studyapp.service.RoleService;
import com.xy.studyapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xy on 2017/6/23.
 */
@Api(description = "角色管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    Logger logger=Logger.getLogger(RoleController.class);


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "角色新增", notes = "")
    BaseResp add(@RequestBody Role role){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>角色新增：role:"+role.getName());
        try {
            roleService.insert(role);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add role faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }


    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    @ApiOperation(value = "角色删除", notes = "")
    BaseResp delete(@PathVariable long id){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>角色删除：id:"+id);
        try {
            roleService.delete(id);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  delete role faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    @ApiOperation(value = "角色全查", notes = "")
    BaseResp delete(){
        BaseResp baseResp=new BaseResp();
        try {
            List<Role> roleList=roleService.findAll();
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(roleList);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  getAll role faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

}
