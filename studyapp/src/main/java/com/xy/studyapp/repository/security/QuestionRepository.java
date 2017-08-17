package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.Question;
import com.xy.studyapp.entity.security.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findById(String id);
    List<Question> findByUserId(String userId, Sort sort);
}
