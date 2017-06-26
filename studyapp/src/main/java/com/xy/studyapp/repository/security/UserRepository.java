package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xy on 2017/6/23.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findByUserNameAndPassword(String userName,String password);
}
