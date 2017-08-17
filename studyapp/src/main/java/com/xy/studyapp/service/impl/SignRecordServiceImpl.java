package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.DateUtil;
import com.xy.studyapp.entity.base.SignRecord;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.repository.security.SignRecordRepository;
import com.xy.studyapp.repository.security.UserRepository;
import com.xy.studyapp.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/8/14.
 */
@Service
public class SignRecordServiceImpl implements SignRecordService {
    @Autowired
    private SignRecordRepository signRecordRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<SignRecord> findByUserId(String userId) throws Exception{
        return signRecordRepository.findByUserIdAndMonth(userId, DateUtil.getMonth());
    }

    @Override
    public boolean insert(SignRecord signRecord) throws Exception{
        User user=userRepository.findById(signRecord.getUserId());
        user.setScore(user.getScore()+2);
        List<SignRecord> signRecords=signRecordRepository.findByUserIdAndMonth(signRecord.getUserId(), DateUtil.getMonth());
        int day=DateUtil.getDay()-1;
        for(SignRecord signRecord1:signRecords){
            if(signRecord1.getDay()==day){
                user.setSignCount(user.getSignCount()+1);
            }
        }
       userRepository.save(user);
        return signRecordRepository.save(signRecord)!=null;
    }

    @Override
    public boolean validate(SignRecord signRecord) throws Exception {
        List<SignRecord> signRecords=signRecordRepository.findByUserIdAndDayAndMonth(signRecord.getUserId(),signRecord.getDay(),signRecord.getMonth());
        return signRecords==null||signRecords.size()<1;
    }
}
