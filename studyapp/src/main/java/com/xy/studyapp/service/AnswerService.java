package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.Answer;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface AnswerService {
    List<Answer> findAll()throws Exception;
    boolean add(Answer answer)throws Exception;
}
