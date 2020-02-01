package com.gugugou.provider.stream.service.Impl;

import com.gugugou.provider.stream.dao.StreamingShopDao;
import com.gugugou.provider.stream.model.ArrangeAndSku;
import com.gugugou.provider.stream.model.ShortVideo;
import com.gugugou.provider.stream.service.StreamingShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StreamingShopServiceImpl implements StreamingShopService {

    @Resource
    private StreamingShopDao streamingShopDao;

    /**根据直播间id和排班间id,查找直播间上线商品的数量*/
    @Override
    public int putawayShopCount(ArrangeAndSku arrangeAndSku) {
        return streamingShopDao.putawayShopCount(arrangeAndSku);
    }

    /**根据直播间id和排班间id,查找长视频的复制链接*/
    @Override
    public ShortVideo queryLongVideo(ShortVideo shortVideo) {
        return streamingShopDao.queryLongVideo(shortVideo);
    }

    /**根据商品id,查找对应的录播链接并且是上线状态*/
    @Override
    public ShortVideo queryShortVideo(ArrangeAndSku arrangeAndSku) {
        return streamingShopDao.queryShortVideo(arrangeAndSku);
    }

    /**根据直播间id和排班id，查找上架商品，根据顺序升序排序*/
    @Override
    public List<ShortVideo> queryShopAndOrder(ArrangeAndSku arrangeAndSku) {
        return streamingShopDao.queryShopAndOrder(arrangeAndSku);
    }
}
