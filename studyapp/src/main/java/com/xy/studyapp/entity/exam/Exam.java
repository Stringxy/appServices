package com.xy.studyapp.entity.exam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xy on 2017/6/27.
 */
@Entity
@Table(name = "t_exam")
public class Exam implements Serializable {
    private static final long serialVersionUID = -1381299111346140172L;
    @Id
    @Column(name="exam_id",length=32)
    private String examId;
    @Column(name="user_id",length=32)
    private String userId;
    @Column(name="user_name",length=64)
    private String userName;
    @Temporal(TemporalType.DATE)
    @Column(name="create_time")
    private Date createTime;
    @Column(name="pic_url",length=256)
    private String picUrl;
    @Column(name="collect_num")
    private Integer collectNum;
    @Column(name="comment_num")
    private Integer commentNum;
    @Column(name="join_num")
    private Integer joinNum;
    @Column(name="avg_score")
    private Double avgScore;

    public Exam() {
        this.examId= UUID.randomUUID().toString().replace("-","");
        this.createTime=new Date();
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }
}
