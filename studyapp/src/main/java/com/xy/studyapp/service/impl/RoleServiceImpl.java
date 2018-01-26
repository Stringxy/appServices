package com.xy.studyapp.service.impl;

import com.xy.studyapp.entity.security.Role;
import com.xy.studyapp.repository.security.RoleRepository;
import com.xy.studyapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/6/23.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findById(String roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public boolean insert(Role role) {
        return roleRepository.save(role)!=null;
    }

    @Override
    public void delete(long id) throws Exception{
         roleRepository.delete(id);
    }
}
