package com.xy.studyapp.repository.weixin;

import com.xy.studyapp.entity.weixin.WeixinTopic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * create by xy on 2017/12/2
 */
public interface TopicReponsitory  extends JpaRepository<WeixinTopic, Long> {

    Page<WeixinTopic> findByCate(Integer cate, Pageable pageable);
    WeixinTopic findById(String id);
    Page<WeixinTopic> findByOpenid(String openid, Pageable pageable);
}
