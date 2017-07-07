package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.other.Banner;
import com.xy.studyapp.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Api(description = "banner管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/banner")
public class BannerController  {
    @Autowired
    private BannerService bannerService;
    Logger logger=Logger.getLogger(BannerController.class);

    @RequestMapping("/findAll")
    @ResponseBody
    @ApiOperation(value = "首页banner全查", notes = "")
    BaseResp findAll(){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>查询所有banner");
        try {
            List<Banner> banners=bannerService.findAll();
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(banners);
        } catch (Exception e) {
            logger.error("---->>  find all banner exception",e);
            BaseResp.setResp(false,baseResp);
        }
        return baseResp;
    }
}
