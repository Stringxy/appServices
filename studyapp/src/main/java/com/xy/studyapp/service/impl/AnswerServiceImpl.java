package com.xy.studyapp.service.impl;

import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.repository.security.AnswerRepository;
import com.xy.studyapp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerRepository answerRepository;
    @Override
    public List<Answer> findAll() throws Exception {
        return answerRepository.findAll();
    }

    @Override
    public boolean add(Answer answer) throws Exception {
        return answerRepository.save(answer)!=null;
    }
}
