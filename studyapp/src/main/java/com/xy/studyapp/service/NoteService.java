package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface NoteService {

    List<Note> findByUserId(String userId)throws Exception;

    boolean add(Note note)throws Exception;

    Note findById(String id)throws Exception;

    public Page<Note> findAll(Integer pageNo,Integer pageSize,Sort sort)throws Exception;

    List<Note> findQuestions();

    List<Note> findNotes();


}
