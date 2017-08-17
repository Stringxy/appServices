package com.xy.studyapp.entity.base;

import java.io.Serializable;

/**
 * Created by xy on 2017/8/1.
 */
public class BaseVo implements Serializable{

    private static final long serialVersionUID = 5209732651153272468L;
    private Integer pageNo;
    private Integer pageSize;

    public BaseVo() {}

    public BaseVo(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
