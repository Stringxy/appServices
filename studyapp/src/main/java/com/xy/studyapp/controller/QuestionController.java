package com.xy.studyapp.controller;

import com.xy.studyapp.common.resp.BaseResp;
import com.xy.studyapp.common.utils.SortUtil;
import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.base.Comment;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.repository.security.AnswerRepository;
import com.xy.studyapp.service.AnswerService;
import com.xy.studyapp.service.CommentService;
import com.xy.studyapp.service.NoteService;
import com.xy.studyapp.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/7/7.
 */
@Api(description = "提问管理,xy")
@RestController
@EnableAutoConfiguration
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CommentService commentService;
    Logger logger=Logger.getLogger(QuestionController.class);

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "提问全查询", notes = "")
    BaseResp home() {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>提问全查询");
        try {
            List<Note> questions=noteService.findQuestions();
            BaseResp.setResp(true,baseResp);
            if(questions==null||questions.size()<1){
                baseResp.setResultNote("当前没有记录。");
            }else {
                baseResp.setDetail(questions);
            }
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
    BaseResp add(@RequestBody Note question){
        BaseResp baseResp=new BaseResp();
        logger.info("------->>提问新增：ques:"+question.toString());
        question.setDefault();
        try {
            question.setType(1);
            boolean bool=noteService.add(question);
            BaseResp.setResp(true,baseResp);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  add ques faild",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "提问查询", notes = "")
    BaseResp findOne(@PathVariable String id) {
        BaseResp baseResp=new BaseResp();
        logger.info("------->>提问查询");
        try {
            Note questions=noteService.findById(id);
            List<Comment> comments=commentService.findByNoteId(id);
            BaseResp.setResp(true,baseResp);
            Map<String,Object> detail=new HashMap<String,Object>();
            if(questions==null){
                baseResp.setResultNote("当前没有记录。");
            }else {
                detail.put("question",questions);
                detail.put("answer",comments);
            }
            baseResp.setDetail(detail);
            return baseResp;
        } catch (Exception e) {
            logger.error("---->>  提问查询异常",e);
            BaseResp.setResp(false,baseResp);
            return baseResp;
        }
    }

}
