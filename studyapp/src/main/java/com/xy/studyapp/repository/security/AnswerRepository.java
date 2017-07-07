package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xy on 2017/7/7.
 */
public interface AnswerRepository  extends JpaRepository<Answer, Long> {
}
