package com.xy.studyapp.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xy on 2017/7/23.
 */
@Entity
@Table(name = "t_comment")
public class Comment implements Serializable{
    private static final long serialVersionUID = -259753006012293338L;
    @Id
    @Column(name="comment_id",length=32)
    private String id;
    @Column(name="comment_content",length=500)
    private String content;
    @Column(name="comment_user",length=32)
    private String commentUser;
    @Column(name="comment_user_name",length=32)
    private String userName;
    @Column(name="pid",length=32)
    private String pId;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="note_id",length=32)
    private String noteId;


    public void setDefault(){
        this.id= UUID.randomUUID().toString().replace("-","");
        this.createTime=new Date();
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

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
