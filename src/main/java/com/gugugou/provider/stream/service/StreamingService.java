package com.gugugou.provider.stream.service;

import com.gugugou.provider.stream.model.*;

import java.util.List;
import java.util.Map;

public interface StreamingService {

    /**添加直播间*/
    int addStreaming(Streaming streaming);

    /**修改直播间*/
    int updateStreaming(Streaming streaming);

    /**直播间列表*/
    List<Streaming> allStreamings(String anchorName);

    /**添加排班表*/
    int addWorkingSchedule(ArrangeStreaming arrangeStreaming);

    /**修改排班直播间的信息*/
    int updateArrange(ArrangeStreaming arrangeStreaming);

    /**添加长视频*/
    int addLongVideo(ShortVideo longVideo);

    /**添加短视频*/
    int addShortVideo(ShortVideo shortVideo);

    /**查找短视频*/
    Map findShortVideo(ShortVideo shortVideo);

    /**根据长视频的开始结束时间查找视频评论*/
    Map findAllCommentById(ShortVideo longVideo);

    /**复制短视频地址*/
    ShortVideo copyUrl(Long id);

    /**根据id查找短视频及商品*/
    ShortVideo findShortById(Long id);

    /**修改短视频商品*/
    int updatedShop(ShortVideo shortVideo);

    /**禁言*/
    int updateCommentStatus(StreamingComment streamingComment);

    /**查看所有的排班表*/
/*    List<ArrangeStreaming> findAllStreaming();*/

    /**展示所有排班直播间*/
    Map findArrangeList(ArrangeStreaming arrangeStreaming);

    /**修该排班直播间的状态*/
    void updateStreamingStatus(ArrangeStreaming information);

    /**查找直播间的商品*/
    List<Commodity> findStreamingShop(FindStreamingShop findStreamingShop);

    /**添加直播间商品*/
    int saveShop(List<ArrangeAndSku> arrangeAndSkus);

    /**排班列表中复制直播路径*/
    String findLongVideo(ShortVideo longVideo);

    /**解冻*/
    int updatedStatus(ArrangeStreaming arrangeStreaming);

    /**排班直播间冻结*/
    int updateArrangeStatus(ArrangeStreaming arrangeStreaming);

    /**删除短视频*/
    int deleteShortVideo(Long id);

    /**修改短视频的上下线状态*/
    int changeShortStatus(ShortVideo shortVideo);

    /**添加评论*/
    int addComment(StreamingComment streamingComment);

    /**修改路径价格*/
    int setPrice(PathAndPrice pathAndPrice);

    /**查找直播路径下商品和sku*/
    List<PathAndPrice> streamingSkuPrice(ArrangeStreaming arrangeStreaming);

    /**直播间的商品sku的路径设置提交*/
    int addStreamingSkuPrice(PathAndPrice pathAndPrice);

    /**直播间售价设置*/
    ArrangeAndSku findStreamingSell(ArrangeSkuId arrangeSkuId);

    /**展示直播间商品和sku属性*/
    List<ArrangeAndSku> showStreamingSku(Long ids);

    /**直播间删除sku*/
    int deleteSkuId(ArrangeSkuId arrangeSkuId);

    /**展示直播间的录播列表*/
    List<ShortVideo> showStreamingRecorded(ShortVideo shortVideo);

    /**排班间商品上架*/
    int putaway(ArrangeAndSku arrangeAndSku);

    /**排班间商品的排班顺序*/
    int shopEdit(ArrangeAndSku arrangeAndSku);

    /**排班间列表的编辑商品*/
    int updatedStreamingShop(List<ArrangeAndSku> arrangeAndSku);

    /**返回排班表中有效状态表*/
    List<ArrangeStreaming> showArrangeRoomStatus(ArrangeStreaming arrangeStreaming);
}
