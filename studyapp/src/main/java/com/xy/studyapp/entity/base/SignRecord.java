package com.xy.studyapp.entity.base;

import com.xy.studyapp.common.utils.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xy on 2017/8/14.
 */
@Entity
@Table(name = "t_sign_record")
public class SignRecord implements Serializable{
    private static final long serialVersionUID = 5079863759170549461L;
    @Id
    @Column(name="record_id",length=32)
    private String id;
    @Column(name="month")
    private Integer month;
    @Column(name="day")
    private Integer day;
    @Column(name="user_id",length=32)
    private String userId;

    public SignRecord() {
        this.setDefault();
    }

    public void setDefault(){
        this.id= UUID.randomUUID().toString().replace("-","");
        this.month= DateUtil.getMonth();
        this.day=DateUtil.getDay();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
