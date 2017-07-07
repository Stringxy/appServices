package com.xy.studyapp.entity.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by xy on 2017/6/27.
 */
@Entity
@Table(name = "t_collect")
public class Collect {
    @Id
    @Column(name="collect_id",length=32)
    private String id;
    @Column(name="user_id",length=32)
    private String userId;
    @Column(name="exam_id",length=32)
    private String examId;

    public Collect() {
        this.id = UUID.randomUUID().toString().replace("-","");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }
}
