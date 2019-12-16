package com.gugugou.provider.stream.service;

import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.Streaming;

public interface StreamingService {
    /**添加直播间*/
    int addStreaming(Streaming streaming);
    /**修改直播间*/
    int updateStreaming(Streaming streaming);
    /**添加排班表*/
    int addWorkingSchedule(ArrangeStreaming arrangeStreaming);
}
