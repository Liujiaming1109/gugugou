package com.gugugou.provider.stream.dao;

import com.gugugou.provider.stream.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StreamingDao {
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

    /**展示所有排班直播间带条件查询*/
    List<ArrangeStreaming> findArrangeList(ArrangeStreaming arrangeStreaming);

    /**展示所有排班直播间(没有条件和冻结)*/
    List<ArrangeStreaming> findArrangeLists();

    /**排班间解冻*/
    int updatedStatus(ArrangeStreaming arrangeStreaming);

    /**排班直播间冻结*/
    int updateArrangeStatus(ArrangeStreaming arrangeStreaming);

    /**添加开始直播*/
    int addLongVideo(ShortVideo longVideo);

    /**添加结束直播*/
    int addEndLongVideo(ShortVideo longVideo);

    /**添加开始直播*/
    int addShortVideo(ShortVideo shortVideo);

    /**添加结束录播*/
    int addEndShortVideo(ShortVideo shortVideo);

    /**查找短视频*/
    List<ShortVideo> findShortVideo(ShortVideo shortVideo);

    /**查找短视频总数*/
    Integer findAllShortVideo(ShortVideo shortVideo);

    /**根据直播间的开始结束时间查找视频评论*/
    List<StreamingComment> findAllCommentById(ShortVideo streamingComment);

    /**???禁言[缺少评论用户表]*/
    int updateCommentStatus(StreamingComment streamingComment);

    /**复制短视频地址*/
    ShortVideo copyUrl(Long id);

    /**根据id查找短视频及商品*/
    ShortVideo findShortById(Long id);

    /**修改短视频商品*/
    int updatedShop(ShortVideo shortVideo);

    /**根据长视频的开始结束时间查找评论的总数*/
    Integer findAllCommentCount(ShortVideo streamingComment);

    /**修该排班直播间的状态*/
    void updateStreamingStatus(ArrangeStreaming information);

    /**查找直播间的商品*/
    List<Commodity> findStreamingShop(FindStreamingShop findStreamingShop);

    /**查找直播间的商品数量*/
    Integer seekShopCount(Long commodityId);

    /**添加直播间商品*/
    int saveShop(ArrangeAndSku arrangeAndSku);

    /**展示排班表中商品的数量*/
    Integer shopCount(ArrangeStreaming arr);

    /**排班列表中复制直播路径*/
    String findLongVideo(ShortVideo longVideo);

    /**删除短视频*/
    int deleteShortVideo(Long id);

    /**修改短视频的上下线状态*/
    int changeShortStatus(ShortVideo shortVideo);

    /**添家直播间的评论*/
    int addComment(StreamingComment streamingComment);

    /**邮箱发送记录表*/
    int addTimingRecord(TimingRecoed timingRecoed);

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

    /**添加排班表下sku表*/
    void saveArrangeSkuFks(ArrangeAndSkuFk comm);

    /**查找排班下sku的集合*/
    List<ArrangeAndSkuFk> showStreamingSkus(@Param("id")Long id, @Param("itemId")Long itemId);

    /**直播间删除sku*/
    int deleteSkuId(ArrangeSkuId arrangeSkuId);

    /**带有这种sku的供应商数量*/
    int getProviderCount(Long commotityId);

    /**查找有该sku的仓库的数量*/
    int getWarehouseCount(Long commotityId);

    /**查看该sku总库存*/
    int getSkuCount(Long commotityId);

    /**展示直播间的录播列表*/
    List<ShortVideo> showStreamingRecorded(ShortVideo shortVideo);

    /**上架商品*/
    int findShopId(ArrangeAndSku arrangeAndSku);

    /**查找该排班下的所有商品*/
    List<ArrangeAndSku> findStreamingOrders(Long arrangeRoomId);

    /**查找原表中商品id的排序数*/
    int findArrangeOrder(int order);

    /**修改排班表下的商品的顺序数*/
    int updateStreamingOrder(ArrangeAndSku arr);

    /**添加sku_path下商品路径表*/
    void saveSkuAndPath(SkuAndPath skuAndPath);

    /**排班间编辑商品*/
    int updatedStreamingShop(ArrangeAndSku arrangeAndSku);

    /**删除排班间原商品id*/
    void deleteStreamingItemShop(ArrangeAndSku arr);

    /**删除排班间商品sku*/
    void deletestreamingSkuShop(ArrangeAndSku arr);

    /**删除原有排班间路径下sku的路径扣点*/
    void deleteSkuAndPath(ArrangeAndSku arr);

    /**查找该排班间下原所有商品*/
    List<ArrangeAndSku> findAllStreamingShopById(Long arrangeRoomId);

    /**返回直播间排班表的有效状态*/
    List<ArrangeStreaming> showArrangeRoomStatus(ArrangeStreaming arrangeStreaming);

    /**查找排班表下有效状态的sku*/
    List<ArrangeAndSkuFk> findStreamingsArrangeSkuFk(ArrangeAndSku arrs);

    /**直播管理-商品管理----添加录播*/
    int updatedShortVideo(ShortVideo shortVideo);

    /**录播管理-录播编辑----变更关联商品*/
    List<ArrangeAndSku> selectStreamingAndShops(Long arrangeRoomId);
}
