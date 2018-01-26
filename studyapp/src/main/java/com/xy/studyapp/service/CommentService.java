package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.Answer;
import com.xy.studyapp.entity.base.Comment;

import java.util.List;

/**
 * Created by xy on 2017/7/23.
 */
public interface CommentService {

    List<Comment> findByNoteId(String id)throws Exception;
    boolean add(Comment comment)throws Exception;
    List<Comment> findByUserId(String id) throws  Exception;
    void delete(String id)throws Exception;
}
