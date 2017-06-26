package com.xy.studyapp.controller;

import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xy on 2017/6/23.
 */
@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/home")
    @ResponseBody
    User home() {
        return userService.findByName("admin");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    User login(@RequestParam String username,@RequestParam  String password){
        return userService.login(username,password);
    }
}
