package com.xy.studyapp.service;

import com.xy.studyapp.entity.security.User;

/**
 * Created by xy on 2017/6/23.
 */
public interface UserService {

    User findByName(String name);
    User login(String username,String password);
}
