package com.xy.studyapp.service;

import com.xy.studyapp.entity.security.Role;

/**
 * Created by xy on 2017/6/23.
 */

public interface RoleService {
    Role findById(String roleId);
}
