package com.xy.studyapp.service.impl;

import com.xy.studyapp.entity.base.Note;
import com.xy.studyapp.repository.security.NoteRepository;
import com.xy.studyapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public List<Note> findByUserId(String userId) throws Exception {
        return noteRepository.findByUserId(userId);
    }

    @Override
    public boolean add(Note note) {
        return noteRepository.save(note)!=null;
    }
}
