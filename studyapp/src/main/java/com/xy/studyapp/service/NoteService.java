package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.Note;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface NoteService {

    List<Note> findByUserId(String userId)throws Exception;

    boolean add(Note note);
}
