package com.xy.studyapp.service.weixin;

import com.xy.studyapp.entity.weixin.WeixinComment;
import com.xy.studyapp.entity.weixin.WeixinTopic;
import com.xy.studyapp.repository.weixin.CommentReponsitory;
import com.xy.studyapp.repository.weixin.TopicReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by xy on 2017/12/5
 */
@Service("weixinCommentService")
public class WeixinCommentServiceImpl implements WeixinCommentService {

    @Autowired
    private CommentReponsitory commentReponsitory;
    @Autowired
    private TopicReponsitory topicReponsitory;
    @Override
    @Transactional
    public boolean add(WeixinComment comment) throws Exception {
        WeixinTopic topic=topicReponsitory.findById(comment.getTopicid());
        topic.setComments(topic.getComments()+1);
        topicReponsitory.save(topic);
        comment.setDefault();
        return  commentReponsitory.save(comment)!=null;
    }

    @Override
    public void delete(String id) throws Exception {
        commentReponsitory.delete(Long.valueOf(id));
    }
}
