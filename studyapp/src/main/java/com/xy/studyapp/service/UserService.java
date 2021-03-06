package com.xy.studyapp.service;

import com.xy.studyapp.entity.security.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * Created by xy on 2017/6/23.
 */
public interface UserService {

    User findByName(String name) throws Exception;

    User login(String username, String password) throws Exception;

    boolean insert(User user) throws Exception;

    User findByNickName(String name) throws Exception;

    boolean updateImage(User user) throws Exception;

    boolean update(User user) throws Exception;

    Page<User> findAll(Integer pageNo, Integer pageSize, Sort sort) throws Exception;

}
