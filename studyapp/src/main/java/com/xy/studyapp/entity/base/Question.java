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
@Table(name = "t_question")
public class Question implements Serializable {
    private static final long serialVersionUID = 8566405066076942439L;
    @Id
    @Column(name="question_id",length=32)
    private String id;
    @Column(name="question_content",length=500)
    private String content;
    @Column(name="user_id",length=32)
    private String userId;
    @Column(name="user_name",length=32)
    private String userName;
    @Column(name="answer_num")
    private Integer answerNum;
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
    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", answerNum=" + answerNum +
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

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }
}
