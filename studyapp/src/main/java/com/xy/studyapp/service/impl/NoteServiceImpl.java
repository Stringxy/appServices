package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.SortUtil;
import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.repository.security.NoteRepository;
import com.xy.studyapp.repository.security.UserRepository;
import com.xy.studyapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Note> findByUserId(String userId) throws Exception {
        Pageable pageable=new PageRequest(0,10,SortUtil.basicSort());
        return noteRepository.findByUserIdAndType(userId,0,pageable);
    }

    @Override
    public boolean add(Note note)throws Exception {
        User user=userRepository.findById(note.getUserId());
        user.setScore(user.getScore()+5);
        userRepository.save(user);
        return noteRepository.save(note)!=null;
    }

    @Override
    public Note findById(String id) throws Exception {
        return noteRepository.findById(id);
    }

    @Override
    public Page<Note> findAll(Integer pageNo,Integer pageSize,Sort sort) throws Exception{
        Pageable pageable=new PageRequest(pageNo,pageSize,sort);
        Page<Note> notePage=noteRepository.findAll(pageable);
        return notePage;
    }

    @Override
    public List<Note> findQuestions() {
        return noteRepository.findByType(0);
    }

    @Override
    public List<Note> findNotes() {
        return  noteRepository.findByType(1);
    }


}
