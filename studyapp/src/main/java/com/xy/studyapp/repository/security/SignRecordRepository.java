package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.base.SignRecord;
import com.xy.studyapp.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/8/14.
 */
public interface SignRecordRepository extends JpaRepository<SignRecord, Long> {
    List<SignRecord> findByUserIdAndMonth (String userId,Integer month);
    List<SignRecord> findByUserIdAndDayAndMonth(String userId,Integer day,Integer month);
}
