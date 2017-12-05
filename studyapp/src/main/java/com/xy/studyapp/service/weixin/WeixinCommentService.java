package com.xy.studyapp.service.weixin;

import com.xy.studyapp.entity.weixin.WeixinComment;

/**
 * create by xy on 2017/12/5
 */
public interface WeixinCommentService {

    boolean add(WeixinComment comment) throws Exception;
    void delete(String id) throws Exception;
}
