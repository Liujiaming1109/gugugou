package com.gugugou.provider.stream.dao;

import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.Streaming;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StreamingDao {
    /**添加直播间*/
    int addStreaming(Streaming streaming);
    /**修改直播间*/
    int updateStreaming(Streaming streaming);
    /**添加排班表*/
    int addWorkingSchedule(ArrangeStreaming arrangeStreaming);

}
