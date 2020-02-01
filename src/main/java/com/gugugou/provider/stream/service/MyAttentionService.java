package com.gugugou.provider.stream.service;

import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.MyAttention;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/30 23:13
 */
public interface MyAttentionService {

    /**
     * 新增一个我的关注
     * @param attention
     * @return
     */
    Integer addMyAttention(MyAttention attention);

    /**
     * 根据用户id查询该用户关注的直播间列表
     * @param userId
     * @return
     */
    List<ArrangeStreaming> selectMyAttentions(Long userId);
}
