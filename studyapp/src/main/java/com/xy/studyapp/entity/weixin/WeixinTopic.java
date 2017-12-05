package com.xy.studyapp.entity.weixin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * create by xy on 2017/12/2
 */
@Table(name="t_topic_weixin")
@Entity
public class WeixinTopic implements Serializable {
    @Id
    @Column(name = "topicid", unique = true, nullable = false)
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "cate")
    private Integer cate;
    @Column(name = "openid")
    private String openid;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "img")
    private String img;
    @Column(name="createTime")
    private Date createTime;
    @Column(name = "comments")
    private Integer comments;
    @Column(name = "views")
    private Integer views;
    @Column(name = "nickName")
    private String nickName;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setDefault() {
        this.views = 0;
        this.comments=0;
        this.createTime=new Date();
        this.id= UUID.randomUUID().toString().replace('-','a');
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCate() {
        return cate;
    }

    public void setCate(Integer cate) {
        this.cate = cate;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
