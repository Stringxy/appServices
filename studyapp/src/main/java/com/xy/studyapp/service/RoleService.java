package com.xy.studyapp.service;

import com.xy.studyapp.entity.security.Role;

import java.util.List;

/**
 * Created by xy on 2017/6/23.
 */

public interface RoleService {
    Role findById(String roleId);
    List<Role> findAll();
    boolean insert(Role role);
    void delete(long id)throws Exception;
}
