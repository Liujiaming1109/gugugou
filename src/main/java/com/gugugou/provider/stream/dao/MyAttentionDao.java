package com.gugugou.provider.stream.dao;

import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.MyAttention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/30 22:57
 */
@Mapper
public interface MyAttentionDao {

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
