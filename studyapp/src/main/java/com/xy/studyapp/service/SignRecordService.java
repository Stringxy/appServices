package com.xy.studyapp.service;

import com.xy.studyapp.entity.base.SignRecord;

import java.util.List;

/**
 * Created by xy on 2017/8/14.
 */
public interface SignRecordService {
    List<SignRecord> findByUserId(String userId)throws Exception;
    boolean insert(SignRecord signRecord)throws Exception;
    boolean validate(SignRecord signRecord)throws Exception;
}
