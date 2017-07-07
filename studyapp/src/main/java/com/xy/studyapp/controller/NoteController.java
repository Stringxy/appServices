package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.service.NoteService;
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
@Api(description = "笔记管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    Logger logger=Logger.getLogger(NoteController.class);

    @RequestMapping("/findByUserId/{id}")
    @ResponseBody
    @ApiOperation(value = "根据userId查询笔记", notes = "")
    BaseResp home(@PathVariable String id) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>笔记查询：userId:"+id);
        try {
            List<Note> note=noteService.findByUserId(id);
            BaseResp.setResp(true,baseResp);
            baseResp.setDetail(note);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  笔记查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增笔记", notes = "")
    BaseResp add(@RequestBody Note note){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>笔记新增：note:"+note.toString());
        note.setDefault();
        try {
            boolean bool=noteService.add(note);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add note faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }
}
