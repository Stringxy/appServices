package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/6/23.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findById(String roleId);

    List<Role> findAll();

}
