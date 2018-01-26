package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/7/23.
 */
public interface CommentRepository  extends JpaRepository<Comment, String> {
    List<Comment> findByNoteId(String id, Sort sort);
    List<Comment> findByCommentUser(String id, Sort sort);
}
