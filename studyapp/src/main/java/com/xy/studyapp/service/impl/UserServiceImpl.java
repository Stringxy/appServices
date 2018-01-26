package com.xy.studyapp.service.impl;

import com.xy.studyapp.common.utils.Base64;
import com.xy.studyapp.common.utils.MD5Util;
import com.xy.studyapp.entity.security.User;
import com.xy.studyapp.repository.security.UserRepository;
import com.xy.studyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by xy on 2017/6/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByName(String name) throws Exception {
        return userRepository.findByUserName(name);
    }

    @Override
    public User login(String username, String password) throws Exception {
        password=MD5Util.GetMD5Code(password);
        return userRepository.findByUserNameAndPassword(username,password);
    }

    @Override
    public boolean insert(User user) throws Exception{
        user.setPassword(MD5Util.GetMD5Code(user.getPassword()));
        return userRepository.save(user)!=null;
    }

    @Override
    public User findByNickName(String name) throws Exception {
        return userRepository.findById(name);
    }

    @Override
    public boolean updateImage(User user) throws Exception {
        User oldUser=userRepository.findById(user.getId());
        //输出base64 数据,截取","之后的值进行转换
        String str = user.getPortrait().substring( user.getPortrait().indexOf(",")+1);
        //System.currentTimeMillis()意思是获取当前系统的时间戳给图片命名
        //实例化Base64转换类  调用里面的GenerateImage方法（把base64数据转为图片）
        //第一个参数base64转图片的必须的base64数据，第二个是转换后生成的图片存放路径
        long currentTime=System.currentTimeMillis();
        Base64.GenerateImage(str, "/usr/java/tomcat/apache-tomcat-8.5.16/webapps/img/"+currentTime+".jpg");
        //数据库存入绝对路径下的图片名称（上传图片即是修改操作）
        oldUser.setPortrait(currentTime+".jpg");
        return userRepository.save(oldUser)!=null;
    }

    @Override
    public boolean update(User user) throws Exception {
        //只支持修改昵称，个性签名
        User old=userRepository.findById(user.getId());
        if(!StringUtils.isEmpty(user.getPersonSign())) {
            old.setPersonSign(user.getPersonSign());
        }
        if(!StringUtils.isEmpty(user.getNickName())) {
            old.setNickName(user.getNickName());
        }
        return userRepository.save(old)!=null;
    }

    @Override
    public  Page<User> findAll(Integer pageNo,Integer pageSize,Sort sort) throws Exception {
        Pageable pageable=new PageRequest(pageNo,pageSize,sort);
        Page<User> page=userRepository.findAll(pageable);
        return page;
    }




}
