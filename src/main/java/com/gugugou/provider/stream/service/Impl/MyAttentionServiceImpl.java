package com.gugugou.provider.stream.service.Impl;

import com.gugugou.provider.stream.dao.MyAttentionDao;
import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.MyAttention;
import com.gugugou.provider.stream.service.MyAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/30 23:14
 */
@Service
public class MyAttentionServiceImpl implements MyAttentionService {

    @Resource
    private MyAttentionDao myAttentionDao;

    @Override
    public Integer addMyAttention(MyAttention attention) {
        MyAttention myAttention = new MyAttention();
        myAttention.setUserId(attention.getUserId());
        myAttention.setDirectBroadcastingRoomId(attention.getDirectBroadcastingRoomId());
        myAttention.setCreatedBy("lalala");
        myAttention.setCreatedTime(new Date());
        myAttention.setRemoved(0);
        return myAttentionDao.addMyAttention(myAttention);
    }

    @Override
    public List<ArrangeStreaming> selectMyAttentions(Long userId) {

        return myAttentionDao.selectMyAttentions(userId);
    }
}
