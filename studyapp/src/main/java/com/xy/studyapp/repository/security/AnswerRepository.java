package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.security.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface AnswerRepository  extends JpaRepository<Answer, Long> {

    List<Answer> findByQuestionId(String id, Sort sort);
    List<Answer> findByUserId(String userId,Sort sort);
}
