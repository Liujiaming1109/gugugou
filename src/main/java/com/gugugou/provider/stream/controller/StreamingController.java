package com.gugugou.provider.stream.controller;

import com.gugugou.provider.stream.model.Streaming;
import com.gugugou.provider.stream.service.StreamingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("streaming")
@RestController
public class StreamingController {

    @Resource
    private StreamingService streamingService;

    /**添加直播间*/
    @RequestMapping("addStreaming")
    public int addStreaming(Streaming streaming){
        return  streamingService.addStreaming(streaming);
    }
    /**修改直播间*/
    @RequestMapping("updateStreaming")
    public int updateStreaiming(Streaming streaming){
        return  streamingService.updateStreaming(streaming);
    }


}
