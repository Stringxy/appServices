package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.MD5Util;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.repository.security.UserRepository;
import com.xy.studyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xy on 2017/6/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByName(String name) throws Exception {
        return userRepository.findByUserName(name);
    }

    @Override
    public User login(String username, String password) throws Exception {
        password=MD5Util.GetMD5Code(password);
        return userRepository.findByUserNameAndPassword(username,password);
    }

    @Override
    public boolean insert(User user) throws Exception{
        user.setPassword(MD5Util.GetMD5Code(user.getPassword()));
        return userRepository.save(user)!=null;
    }
}
