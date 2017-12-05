package com.xy.studyapp.repository.weixin;

import com.xy.studyapp.entity.weixin.WeixinUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by xy on 2017/12/2
 */
public interface WeixinUserReponsitory extends JpaRepository<WeixinUser, Long> {

    WeixinUser findByNickNameAndAvatarUrl(String sign,String avatarUrl);
}
