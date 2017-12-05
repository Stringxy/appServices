package com.xy.studyapp.service.weixin;

import com.xy.studyapp.entity.weixin.TopicVo;
import com.xy.studyapp.entity.weixin.WeixinTopic;
import org.springframework.data.domain.Page;

/**
 * create by xy on 2017/12/2
 */
public interface WeixinService {
    String getOpenId(String code);
    boolean add(WeixinTopic note)throws Exception;
    Page<WeixinTopic> getTopics(TopicVo vo) throws Exception;
    WeixinTopic getTopicById(String id)throws Exception;
    Page<WeixinTopic> getTopicByOpenid(TopicVo vo) throws Exception;
}
