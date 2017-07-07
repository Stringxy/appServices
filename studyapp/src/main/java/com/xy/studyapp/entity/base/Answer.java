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
@Table(name = "t_answer")
public class Answer implements Serializable{
    private static final long serialVersionUID = -6216625406927424311L;
    @Id
    @Column(name="answer_id",length=32)
    private String id;
    @Column(name="answer_content",length=32)
    private String content;
    @Column(name="user_id",length=32)
    private String userId;
    @Column(name="user_name",length=32)
    private String userName;
    @Column(name="question_id",length=32)
    private String questionId;
    @Column(name="create_time")
    private Date createTime;
    public void setDefault(){
        this.id= UUID.randomUUID().toString().replace("-","");
        this.createTime=new Date();
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

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", questionId='" + questionId + '\'' +
                '}';
    }
}
