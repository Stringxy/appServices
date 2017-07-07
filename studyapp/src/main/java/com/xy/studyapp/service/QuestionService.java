package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.Question;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface QuestionService {

    boolean insert(Question question) throws Exception;

    List<Question> findAll() throws Exception;
}
