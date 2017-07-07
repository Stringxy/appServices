package com.xy.studyapp.service.impl;

import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.repository.security.QuestionRepository;
import com.xy.studyapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public boolean insert(Question question) throws Exception {
        return questionRepository.save(question)!=null;
    }

    @Override
    public List<Question> findAll() throws Exception {
        return questionRepository.findAll();
    }
}
