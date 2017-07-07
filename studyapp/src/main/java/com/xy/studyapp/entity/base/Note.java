package com.xy.studyapp.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xy on 2017/7/7.
 */
@Entity
@Table(name = "t_note")
public class Note implements Serializable {
    private static final long serialVersionUID = -3385265414037764993L;
    @Id
    @Column(name="note_id",length=32)
    private String id;
    @Column(name="note_content",length=500)
    private String content;
    @Column(name="user_id",length=32)
    private String userId;
    @Column(name="user_name",length=32)
    private String userName;
    @Column(name="create_time")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDefault(){
        this.id= UUID.randomUUID().toString().replace("-","");
        this.createTime=new Date();
    }


    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
