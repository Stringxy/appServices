package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.Note;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface NoteRepository extends PagingAndSortingRepository<Note, String> {
    List<Note> findAll();
    List<Note> findByUserIdAndType(String userId, Integer type,Pageable pageable);
    Note findById(String id);
    List<Note> findByType(Integer type);
}
