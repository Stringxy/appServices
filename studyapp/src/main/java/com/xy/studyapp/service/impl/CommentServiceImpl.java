package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.SortUtil;
import com.xy.studyapp.entity.base.Comment;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.repository.security.CommentRepository;
import com.xy.studyapp.repository.security.NoteRepository;
import com.xy.studyapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xy on 2017/7/23.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public List<Comment> findByNoteId(String id) throws Exception {
        return commentRepository.findByNoteId(id,SortUtil.basicSort());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Comment comment) throws Exception {
        Note note=noteRepository.findById(comment.getNoteId());
        note.setCommentNum(note.getCommentNum()+1);
        noteRepository.save(note);
        return commentRepository.save(comment)!=null;
    }

    @Override
    public List<Comment> findByUserId(String id) throws Exception {
        return commentRepository.findByCommentUser(id, SortUtil.basicSort());
    }
}
