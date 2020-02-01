package com.gugugou.provider.stream.dao;

import com.gugugou.provider.stream.model.ArrangeAndSku;
import com.gugugou.provider.stream.model.ShortVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StreamingShopDao {

    /**根据直播间id和排班间id,来查找直播间上线的商品数量*/
    int putawayShopCount(ArrangeAndSku arrangeAndSku);

    /**根据直播间id和排班间id,来查找长视频复制链接*/
    ShortVideo queryLongVideo(ShortVideo shortVideo);

    /**根据商品id,查找对应的录播连接地址并且是上线状态*/
    ShortVideo queryShortVideo(ArrangeAndSku arrangeAndSku);

    /**根据直播间id和排班id，查找上架商品，根据顺序升序排序*/
    List<ShortVideo> queryShopAndOrder(ArrangeAndSku arrangeAndSku);
}
