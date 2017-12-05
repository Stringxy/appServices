package com.xy.studyapp.entity.weixin;

import com.xy.studyapp.entity.base.BaseVo;

/**
 * create by xy on 2017/12/2
 */
public class TopicVo extends BaseVo{
    private Integer cate;
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getCate() {
        return cate;
    }

    public void setCate(Integer cate) {
        this.cate = cate;
    }

    public TopicVo() {}

    public TopicVo(Integer pageNo, Integer pageSize) {
        super(pageNo, pageSize);
    }
}
