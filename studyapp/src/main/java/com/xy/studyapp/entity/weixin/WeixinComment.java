package com.xy.studyapp.entity.weixin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * create by xy on 2017/12/5
 */
@Table(name="t_comment_weixin")
@Entity
public class WeixinComment implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;
    @Column(name = "content")
    private String content;
    @Column(name = "openid")
    private String openid;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "nickName")
    private String nickName;
    @Column(name = "topicid")
    private String topicid;

    public void setDefault(){
        this.id= UUID.randomUUID().toString().replace("-","a");
        this.createTime=new Date();
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
