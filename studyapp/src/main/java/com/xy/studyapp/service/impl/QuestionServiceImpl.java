package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.SortUtil;
import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.repository.security.QuestionRepository;
import com.xy.studyapp.repository.security.UserRepository;
import com.xy.studyapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean insert(Question question) throws Exception {
        User user=userRepository.findByUserName(question.getUserName());
        user.setScore(user.getScore()+5);
        return questionRepository.save(question)!=null;
    }

    @Override
    public List<Question> findAll(Sort sort) throws Exception {
        return questionRepository.findAll(sort);
    }

    @Override
    public Question findOne(String id) throws Exception {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> findByUserId(String userId) throws Exception {
        return questionRepository.findByUserId(userId, SortUtil.basicSort());
    }


}
