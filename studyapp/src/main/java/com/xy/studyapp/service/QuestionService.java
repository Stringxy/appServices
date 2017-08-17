package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.Question;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface QuestionService {

    boolean insert(Question question) throws Exception;

    List<Question> findAll(Sort sort) throws Exception;

    Question findOne(String id) throws Exception;

    List<Question> findByUserId(String userId) throws Exception;
}
