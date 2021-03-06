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
public class User implements Serializable {
    private static final long serialVersionUID = 8208666454898720322L;
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String id;
    @Column(name = "username", length = 120)
    private String userName;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password", length = 120)
    private String password;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_time", length = 10)
    private Date createTime;
    @Column(name = "nickname", length = 32)
    private String nickName;
    @Column(name = "role_id", length = 32)
    private Integer roleId;
    @Column(name = "mobile", length = 32)
    private String mobile;
    @Column(name = "level")
    private Integer level;
    @Column(name = "score")
    private Integer score;
    @Column(name = "portrait")
    private String portrait;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "sign_count")
    private Integer signCount;
    @Column(name = "personal_sign")
    private String personSign;
    @Column(name = "status")
    private Integer status;

    public User() {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.createTime = new Date();
        this.signCount = 0;
        this.score = 0;
        this.level = 1;
        this.portrait = "avatar0.jpg";
        this.personSign = "这个人很懒，还没有个性签名...";
        this.status = 1;
        this.roleId = 1;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPersonSign() {
        return personSign;
    }

    public void setPersonSign(String personSign) {
        this.personSign = personSign;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
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

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }
}
