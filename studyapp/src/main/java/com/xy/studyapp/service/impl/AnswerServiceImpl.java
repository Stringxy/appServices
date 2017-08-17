package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.SortUtil;
import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.repository.security.AnswerRepository;
import com.xy.studyapp.repository.security.QuestionRepository;
import com.xy.studyapp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Answer> findAll() throws Exception {
        return answerRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Answer answer) throws Exception {
        Question question=questionRepository.findById(answer.getQuestionId());
        question.setAnswerNum(question.getAnswerNum()+1);
        questionRepository.save(question);
        return answerRepository.save(answer)!=null;
    }

    @Override
    public List<Answer> findByQuestionId(String id) throws Exception {
        return answerRepository.findByQuestionId(id,SortUtil.basicSort());
    }

    @Override
    public List<Answer> findByUserId(String id) throws Exception {
        return answerRepository.findByUserId(id,SortUtil.basicSort());
    }
}
