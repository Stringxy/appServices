package com.xy.studyapp.entity.security;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xy on 2017/6/23.
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable{
    private static final long serialVersionUID = 8208666454898720322L;
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String id;
    @Column(name = "username", length = 120)
    private String userName; //用户名
    @Column(name = "email", length = 50)
    private String email;//用户邮箱
    @Column(name = "password", length = 120)
    private String password;//用户密码
    @Temporal(TemporalType.DATE)
    @Column(name = "create_time", length = 10)
    private Date createTime;//时间
    @Column(name = "nickname", length = 32)
    private String nickName;
    @Column(name = "role_id", length = 32)
    private String roleId;
    @Column(name = "mobile", length = 32)
    private String mobile;
    @Column(name = "level")
    private Integer level;
    @Column(name = "score")
    private Integer score;

    public User() {
        this.id= UUID.randomUUID().toString().replace("-","");
        this.createTime=new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
