package com.gugugou.provider.stream.service.Impl;

import com.gugugou.provider.stream.dao.StreamingDao;
import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.Streaming;
import com.gugugou.provider.stream.service.StreamingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StreamingServiceImpl implements StreamingService {

    @Resource
    private StreamingDao streamingDao;

    @Override
    public int addStreaming(Streaming streaming) {
        return streamingDao.addStreaming(streaming);
    }

    @Override
    public int updateStreaming(Streaming streaming) {
        return streamingDao.updateStreaming(streaming);
    }

    @Override
    public int addWorkingSchedule(ArrangeStreaming arrangeStreaming) {
        return streamingDao.addWorkingSchedule(arrangeStreaming);
    }
}
