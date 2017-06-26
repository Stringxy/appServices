package com.xy.studyapp.security.support;

import com.xy.studyapp.entity.security.Role;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.repository.security.RoleRepository;
import com.xy.studyapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xy on 2017/6/23.
 */
public class SecurityUser  extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Autowired
    RoleService roleService;
    public SecurityUser(User suser) {
        if(suser != null)
        {
            this.setId(suser.getId());
            this.setUserName(suser.getUserName());
            this.setEmail(suser.getEmail());
            this.setPassword(suser.getPassword());
            this.setCreateTime(suser.getCreateTime());
            this.setRoleId(suser.getRoleId());
            this.setNickName(suser.getNickName());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();

                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleService.findById(this.getRoleId()).getName());
                authorities.add(authority);

        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
