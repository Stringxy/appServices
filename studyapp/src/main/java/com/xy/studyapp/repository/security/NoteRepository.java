package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAll();
    List<Note> findByUserId(String userId);

}
