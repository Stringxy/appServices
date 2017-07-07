package com.xy.studyapp.service;

import com.xy.studyapp.entity.security.User;

/**
 * Created by xy on 2017/6/23.
 */
public interface UserService {

    User findByName(String name) throws Exception;
    User login(String username,String password)  throws Exception;
    boolean insert(User user) throws Exception;
}
