package com.gugugou.provider.stream.controller;

import com.gugugou.provider.stream.model.ArrangeAndSku;
import com.gugugou.provider.stream.model.ShortVideo;
import com.gugugou.provider.stream.service.StreamingShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("streamingShop")
@RestController
public class StreamingShopController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private StreamingShopService streamingShopService;

    /**根据直播间id和排班id，统计上架商品的数量*/
    @PostMapping("putawayShopCount")
    public int putawayShopCount(@RequestBody ArrangeAndSku arrangeAndSku){
           logger.info("根据直播间id和排班id,统计上架商品的参数----shortVideo",arrangeAndSku);
           return streamingShopService.putawayShopCount(arrangeAndSku);
    }

    /**根据直播间id和排班id，查找对应长视频连接*/
    @PostMapping("queryLongVideo")
    public ShortVideo queryLongVideo(@RequestBody ShortVideo shortVideo){
        logger.info("根据直播间id和排班id,查找对应长视频链接参数----shortVideo",shortVideo);
        return streamingShopService.queryLongVideo(shortVideo);
    }

    /**根据商品id，查找对应录播连接、上架状态*/
    @PostMapping("queryShopShortVideo")
    public ShortVideo queryShortVideo(@RequestBody ArrangeAndSku arrangeAndSku){
        logger.info("根据商品id,查找对应录播连接的参数时----arrangeAndSku",arrangeAndSku);
        return  streamingShopService.queryShortVideo(arrangeAndSku);
    }

    /**根据直播间id和排班id，查找上架商品，根据顺序升序排序*/
    @PostMapping("queryShopAndOrder")
    public List<ShortVideo> queryShopAndOrder(@RequestBody ArrangeAndSku arrangeAndSku){
        logger.info("根据直播间id和排班间id,查找是商品id并且排序,上架状态参数----arrangeAndSku",arrangeAndSku);
        return  streamingShopService.queryShopAndOrder(arrangeAndSku);
    }


}
