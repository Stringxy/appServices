package com.xy.studyapp.repository.weixin;

import com.xy.studyapp.entity.weixin.WeixinComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by xy on 2017/12/5
 */
public interface CommentReponsitory  extends JpaRepository<WeixinComment, Long> {
}
