package com.xy.studyapp.service.weixin;

import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.xy.studyapp.common.utils.SortUtil;
import com.xy.studyapp.entity.weixin.TopicVo;
import com.xy.studyapp.entity.weixin.WeixinTopic;
import com.xy.studyapp.repository.weixin.TopicReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * create by xy on 2017/12/2
 */
@Service("weixinService")
public class WeixinServiceImpl implements WeixinService {
    private static final String APPID="wx1ba013fd2439f3fd";
    private static final String SECRET="15aaff15d06af23af13cad49385d095a";
    private static final String OPENIDAPI="https://api.weixin.qq.com/sns/jscode2session?appid=";
    @Autowired
    private TopicReponsitory topicReponsitory;
    @Override
    public String getOpenId(String code) {
        String response=HttpUtil.get(OPENIDAPI+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code");
        System.out.println("获取openid:"+response);
        JSONObject res=JSONObject.parseObject(response);
        return res.getString("openid");
    }

    /**
     * 发布话题
     * @param note
     * @return
     * @throws Exception
     */
    @Override
   // @Transactional
    public boolean add(WeixinTopic note) throws Exception {
        note.setDefault();
        return topicReponsitory.save(note)!=null;
    }

    /**
     * 查询所有话题
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public Page<WeixinTopic> getTopics(TopicVo vo)  throws Exception {
        Pageable pageable=new PageRequest(vo.getPageNo(),vo.getPageSize(), SortUtil.basicSort());
        if(vo.getCate()==1){
           return topicReponsitory.findAll(pageable);
        }else{
            return topicReponsitory.findByCate(vo.getCate(),pageable);
        }
    }

    /**
     * 根据id查询话题
     * @param id
     * @return
     * @throws Exception
     */
    @Override
   // @Transactional
    public WeixinTopic getTopicById(String id) throws Exception {
        WeixinTopic topic=topicReponsitory.findById(id);
        topic.setViews(topic.getViews()+1);
        topicReponsitory.save(topic);
        return topic;
    }

    @Override
    public Page<WeixinTopic> getTopicByOpenid(TopicVo vo) throws Exception {
        Pageable pageable=new PageRequest(vo.getPageNo(),vo.getPageSize(), SortUtil.basicSort());
        return topicReponsitory.findByOpenid(vo.getOpenid(),pageable);

    }


}
