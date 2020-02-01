package com.gugugou.provider.stream.service.Impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.stream.dao.StreamingDao;
import com.gugugou.provider.stream.model.*;
import com.gugugou.provider.stream.service.StreamingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class StreamingServiceImpl implements StreamingService {

    @Resource
    private StreamingDao streamingDao;

    /**添加直播间*/
    @Override
    public int addStreaming(Streaming streaming) {
        streaming.setCreatedTime(new Date());
        return streamingDao.addStreaming(streaming);
    }

    /**修改直播间*/
    @Override
    public int updateStreaming(Streaming streaming) {
        streaming.setUpdatedTime(new Date());
        return streamingDao.updateStreaming(streaming);
    }

    /**展示直播间列表*/
    @Override
    public List<Streaming> allStreamings(String anchorName){
        return streamingDao.allStreamings(anchorName);
    }

    /**添加排班*/
    @Override
    public int addWorkingSchedule(ArrangeStreaming arrangeStreaming) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        /**获取创建的开始时间*/
        Date anchorStartDate = arrangeStreaming.getAnchorStartDate();
        /**获取创建的结束时间*/
        Date anchorEndDate = arrangeStreaming.getAnchorEndDate();
        Date date = new Date();

        long dateTime = anchorEndDate.getTime();
        long dateTime1 = anchorEndDate.getTime();
        long dateTime2 = date.getTime();
        if(dateTime > dateTime2){
            arrangeStreaming.setStreamingStatus(1);
        }else if(dateTime2 > dateTime && dateTime1 > dateTime){
            arrangeStreaming.setStreamingStatus(0);
        }else{
            arrangeStreaming.setStreamingStatus(2);
        }
        arrangeStreaming.setCreatedTime(new Date());
        return streamingDao.addWorkingSchedule(arrangeStreaming);
    }

    /**修改排班直播间的信息*/
    @Override
    public int updateArrange(ArrangeStreaming arrangeStreaming) {
        arrangeStreaming.setUpdatedTime(new Date());
        return streamingDao.updateArrange(arrangeStreaming);
    }

    /**添加开始直播*/
    @Override
    public int addLongVideo(ShortVideo longVideo) {
            /**实际开始时间*/
            longVideo.setActualStartTime(new Date());
            /**创建时间*/
            longVideo.setCreatedTime(new Date());
            /**长视频类型*/
            longVideo.setType(0);
            /**调用腾讯云接口*/
            String add = "";
        return streamingDao.addLongVideo(longVideo);
    }

    /**添加结束直播*/
    @Override
    public int addEndLongVideo(ShortVideo longVideo) {
        longVideo.setActualEndTime(new Date());
        longVideo.setType(0);
        /**调腾讯云接口,获取直播流的地址*/
        String str = "调腾讯云接口";
        longVideo.setVideoUrl(str);
        return streamingDao.addEndLongVideo(longVideo);
    }

    /**添加开始录播*/
    @Override
    public int addShortVideo(ShortVideo shortVideo) {
        /**录播开始时间*/
        shortVideo.setActualStartTime(new Date());
        shortVideo.setCreatedTime(new Date());
        shortVideo.setType(1);
        /**调用腾讯云的接口*/
        String str = "";
        return streamingDao.addShortVideo(shortVideo);
    }

    /**添加结束直播*/
    @Override
    public int addEndShortVideo(ShortVideo shortVideo) {
        shortVideo.setActualEndTime(new Date());
        shortVideo.setType(0);
        /**调用腾讯接口*/
        String str = "";
        shortVideo.setVideoUrl(str);
        return streamingDao.addEndShortVideo(shortVideo);
    }

    /**查找短视频*/
    @Override
    public Map findShortVideo(ShortVideo shortVideo) {
        Map<Object,Object> returnMap = new HashMap<>();
        Integer pageIndex = (shortVideo.getPageIndex() - ProviderCentreConsts.INTEGER_ONE)*(shortVideo.getPageSize());
        shortVideo.setPageIndex(pageIndex);
        shortVideo.setType(1);
        List<ShortVideo> shortVideo1 = streamingDao.findShortVideo(shortVideo);
        if(!shortVideo1.isEmpty()){
            returnMap.put("data",shortVideo1);
        }else{
            returnMap.put("data",new ArrayList<>());
        }
        Integer count = streamingDao.findAllShortVideo(shortVideo);
        if(null !=count && count > ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO){
            returnMap.put("count",count);
        }
        return returnMap;
    }

    /**根据排班间id和开始结束时间查找评论*/
    @Override
    public Map findAllCommentById(ShortVideo streamingComment) {
     Map<Object,Object> returnMap = new HashMap<Object,Object>();
     Integer pageIndex = (streamingComment.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*(streamingComment.getPageSize());
     streamingComment.setPageIndex(pageIndex);
     List<StreamingComment> allCommentById = streamingDao.findAllCommentById(streamingComment);
     if(!allCommentById.isEmpty()){
         returnMap.put("data",allCommentById);
     }else{
         returnMap.put("data",new ArrayList<>());
     }
        Integer count =  streamingDao.findAllCommentCount(streamingComment);
       if(null != count && count > ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO){
             returnMap.put("count",count);
       }
        return returnMap;
    }

    /**复制短视频地址*/
    @Override
    public ShortVideo copyUrl(Long id) {
        return streamingDao.copyUrl(id);
    }

    /**根据id查找短视频及商品*/
    @Override
    public ShortVideo findShortById(Long id) {
        return streamingDao.findShortById(id);
    }

    /**修改短视频商品id*/
    @Override
    public int updatedShop(ShortVideo shortVideo) {
        shortVideo.setUpdatedTime(new Date());
        return streamingDao.updatedShop(shortVideo);
    }

    /**禁言(缺少评论人的表)*/
    @Override
    public int updateCommentStatus(StreamingComment streamingComment) {
        streamingComment.setUpdatedTime(new Date());
        return streamingDao.updateCommentStatus(streamingComment);
    }

    /**展示所有排班所有直播间和关联商品的数量*/
    @Override
    public Map findArrangeList(ArrangeStreaming arrangeStreaming) {
        /**获取开起始时间*/
        Date anchorEndDate = arrangeStreaming.getAnchorEndDate();
        /**获取结束时间*/
        Date anchorEndDate1 = arrangeStreaming.getAnchorEndDate();


        List<Integer> count = new ArrayList<Integer>();
        Map<Object,Object> hashMap = new HashMap<>();
        List<ArrangeStreaming> arrangeList = streamingDao.findArrangeList(arrangeStreaming);
        for (ArrangeStreaming arr:arrangeList) {
            Integer integer = streamingDao.shopCount(arr);
            count.add(integer);
        }
        hashMap.put("count",count);
        hashMap.put("arrangeList",arrangeList);
        return hashMap;
    }

    /**修该排班直播间的状态(用于更新直播时间的状态)*/
    @Override
    public void updateStreamingStatus(ArrangeStreaming information) {
           streamingDao.updateStreamingStatus(information);
    }

    /**查找直播间商品*/
    @Override
    public List<Commodity> findStreamingShop(FindStreamingShop findStreamingShop) {
        List<Commodity> streamingShop = streamingDao.findStreamingShop(findStreamingShop);
        if(streamingShop != null){
            for (Commodity comm: streamingShop) {
                streamingDao.seekShopCount(comm.getItemId());
            }
        }
        List<Integer> count = new ArrayList<Integer>();
        return streamingDao.findStreamingShop(findStreamingShop);
    }

    /**添加直播间的商品*/
    @Override
    public int saveShop(List<ArrangeAndSku> arrangeAndSkus) {
        SkuAndPath skuAndPath = new SkuAndPath();
        if(arrangeAndSkus != null){
        for (ArrangeAndSku arrange:arrangeAndSkus) {
            if(arrange.getCommtitys()!=null && arrange.getCommtitys().size()>0 ){
                List<ArrangeAndSkuFk> commtitys = arrange.getCommtitys();
                for (ArrangeAndSkuFk comm: commtitys) {
                     comm.setArrangeSkuId(arrange.getId());
                     skuAndPath.setSkuId(comm.getCommotityId());
                     skuAndPath.setItemPathId(comm.getArrangeSkuId());
                     skuAndPath.setPoint(1);
                     streamingDao.saveSkuAndPath(skuAndPath);
                      streamingDao.saveArrangeSkuFks(comm);
                }
            }
            arrange.setCreatedTime(new Date());
            streamingDao.saveShop(arrange);
          }
        }
        return 1;
    }

    /**排班中复制录播路径*/
    @Override
    public String findLongVideo(ShortVideo longVideo) {
        return streamingDao.findLongVideo(longVideo);
    }

    /**解冻*/
    @Override
    public int updatedStatus(ArrangeStreaming arrangeStreaming) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date anchorStartDate = arrangeStreaming.getAnchorStartDate();
        Date anchorEndDate = arrangeStreaming.getAnchorEndDate();
        long dateTime = anchorStartDate.getTime();
        long dateTime1 = anchorEndDate.getTime();
        long timeMillis = System.currentTimeMillis();
        long Tdate = dateTime - timeMillis;
        long Tdate1 = dateTime1 - timeMillis;
        if(Tdate > 0){
            arrangeStreaming.setStreamingStatus(1);
        }else if(Tdate <= 0 && Tdate1 >= 0){
            arrangeStreaming.setStreamingStatus(0);
        }else{
            arrangeStreaming.setStreamingStatus(2);
        }
        return streamingDao.updatedStatus(arrangeStreaming);
    }

    /**冻结*/
    @Override
    public int updateArrangeStatus(ArrangeStreaming arrangeStreaming) {
        return streamingDao.updateArrangeStatus(arrangeStreaming);
    }

    /**删除短视频*/
    @Override
    public int deleteShortVideo(Long id) {
        return streamingDao.deleteShortVideo(id);
    }

    /**修改短视频上下线状态*/
    @Override
    public int changeShortStatus(ShortVideo shortVideo) {
        return streamingDao.changeShortStatus(shortVideo);
    }

    /**添加直播间的评论*/
    @Override
    public int addComment(StreamingComment streamingComment) {
        streamingComment.setCommentTime(new Date());
        streamingComment.setCreatedTime(new Date());
        return streamingDao.addComment(streamingComment);
    }


    /**修改路径价格*/
    @Override
    public int setPrice(PathAndPrice pathAndPrice) {
        return streamingDao.setPrice(pathAndPrice);
    }

    /**查找直播路径下的商品和sku*/
    @Override
    public List<PathAndPrice> streamingSkuPrice(ArrangeStreaming arrangeStreaming) {
        return streamingDao.streamingSkuPrice(arrangeStreaming);
    }

    /**直播间的商品sku的路径设置提交*/
    @Override
    public int addStreamingSkuPrice(PathAndPrice pathAndPrice) {
        return streamingDao.addStreamingSkuPrice(pathAndPrice);
    }
    /**直播间售价设置*/
    @Override
    public ArrangeAndSku findStreamingSell(ArrangeSkuId arrangeSkuId) {
        return streamingDao.findStreamingSell(arrangeSkuId);
    }

    /**展示直播间的商品和sku属性集合*/
    @Override
    public List<ArrangeAndSku> showStreamingSku(Long ids) {
        /**获取该直播间的商品的集合*/
        List<ArrangeAndSku> arrangeAndSkus = streamingDao.showStreamingSku(ids);

        for (ArrangeAndSku arrange: arrangeAndSkus) {
            /**获取排班表与sku的中间表的主键id*/
            Long id = arrange.getId();
            /**获取商品id*/
            Long itemId = arrange.getItemId();
            /**查找skud的集合*/
            List<ArrangeAndSkuFk> skus = streamingDao.showStreamingSkus(id,itemId);
            for (ArrangeAndSkuFk arr:skus) {
                Long commotityId = arr.getCommotityId();
                int count = streamingDao.getProviderCount(commotityId);
                arr.setProviderCount(count);
                int warehouseCounts = streamingDao.getWarehouseCount(commotityId);
                arr.setWarehouseCount(warehouseCounts);
                int skuCount = streamingDao.getSkuCount(commotityId);
                arr.setSkuCount(skuCount);

            }
            arrange.setCommtitys(skus);

        }
        return arrangeAndSkus;
    }

    /**直播间删除sku*/
    @Override
    public int deleteSkuId(ArrangeSkuId arrangeSkuId) {
        return streamingDao.deleteSkuId(arrangeSkuId);
    }

    /**展示直播间的录播列表*/
    @Override
    public List<ShortVideo> showStreamingRecorded(ShortVideo shortVideo) {
        return streamingDao.showStreamingRecorded(shortVideo);
    }

    /**排班表商品上架*/
    @Override
    public int putaway(ArrangeAndSku arrangeAndSku) {
        return streamingDao.findShopId(arrangeAndSku);
    }

    /**排班间商品的id*/
    @Override
    public int shopEdit(ArrangeAndSku arrangeAndSku) {
        /**查找该排班表下所有商品的顺序*/
        List<ArrangeAndSku> findStreamingOrdes = streamingDao.findStreamingOrders(arrangeAndSku.getArrangeRoomId());

        /**查找原表中商品id的排序*/
        int math = streamingDao.findArrangeOrder(arrangeAndSku.getOrder());

        /**前台传过来的顺序数*/
        int orders = arrangeAndSku.getOrder();
        if(math == orders){
            return 0;
        }
       /* if(orders > math){
            for (ArrangeAndSku arr: findStreamingOrdes) {
                 if(math < arr.getOrder() && arr.getOrder() >= orders){
                       arr.setOrder(arr.getOrder()-1);
                       streamingDao.updateStreamingOrder(arr);
                 }
            }
            streamingDao.updateStreamingOrder(arrangeAndSku);
        }else{
            for (ArrangeAndSku arr: findStreamingOrdes) {
                if(math > arr.getOrder() && arr.getOrder() >= orders){
                    arr.setOrder(arr.getOrder()+1);
                    streamingDao.updateStreamingOrder(arr);
                }
            }
           streamingDao.updateStreamingOrder(arrangeAndSku);
        }*/
       if(orders > math){
           for (ArrangeAndSku arr: findStreamingOrdes) {
                   if(arr.getOrder() >= orders){
                      arr.setOrder(arr.getOrder() + 1);
                      streamingDao.updateStreamingOrder(arr);
                   }
           }
       }else if(orders < math){
           for (ArrangeAndSku arr: findStreamingOrdes) {
               if(arr.getOrder() >= orders){
                   arr.setOrder(arr.getOrder() + 1);
                   streamingDao.updateStreamingOrder(arr);
               }
           }
       }

        return 1;
    }

    /**排班间列表编辑商品(代码写到端点那面了)*/
    @Override
    public int updatedStreamingShop(List<ArrangeAndSku> arrangeAndSku) {

        Map<Object, Object> returnMap = new HashMap<>();
        if(arrangeAndSku.size()>0 && arrangeAndSku != null){
            /**循环排班间添加的商品*/
            for (ArrangeAndSku arr: arrangeAndSku) {

                /**查看原排班表的商品*/
                List<ArrangeAndSku> arrangeAndSkus = streamingDao.findAllStreamingShopById(arr.getArrangeRoomId());
                /**循环原排班表的商品*/
                for (ArrangeAndSku arrs: arrangeAndSkus) {
                    if(arr.getItemId() == arrs.getItemId()){
                        break;
                    }
                }
                Long itemId = arr.getItemId();

            }
            /**删除*/
            return 1;
        }else{
            return 0;
        }


    }

    /**返回排班表中有效状态表*/
    @Override
    public List<ArrangeStreaming> showArrangeRoomStatus(ArrangeStreaming arrangeStreaming) {
        /**查找有效状态的排班表*/
        List<ArrangeStreaming> arrangeStreamings = streamingDao.showArrangeRoomStatus(arrangeStreaming);
        for (ArrangeStreaming arr:arrangeStreamings) {
            /**添加排班表与sku表的中间商品表*/
            List<ArrangeAndSku> streamingOrders = streamingDao.findStreamingOrders(arr.getId());
            arr.setArrangeAndSku(streamingOrders);
            for (ArrangeAndSku arrs:streamingOrders) {
                /**查找排班表有效状态的sku*/
                List<ArrangeAndSkuFk> commoditiess = streamingDao.findStreamingsArrangeSkuFk(arrs);
                arrs.setCommtitys(commoditiess);
            }
        }
        return arrangeStreamings;
    }

    /**直播管理-商品管理----添加录像*/
    @Override
    public int updatedShortVideo(ShortVideo shortVideo) {

        return streamingDao.updatedShortVideo(shortVideo);
    }

    /**录播管理-录播编辑----变更关联商品*/
    @Override
    public List<ArrangeAndSku> selectStreamingAndShops(ShortVideo shortVideo) {
         /**没有去重*/
        return streamingDao.selectStreamingAndShops(shortVideo.getArrangeRoomId());
    }


    @Override
    public List<ShortVideo> selectVideos() {

        List<ShortVideo> videos = streamingDao.selectVideos();
        if (!videos.isEmpty()){
            return videos;
        }
        return null;
    }

    @Override
    public ShortVideo selectVideo(Long directBroadcastingRoomId) {

        List<ShortVideo> videos = streamingDao.selectVideo(directBroadcastingRoomId);
        if (!videos.isEmpty()){
            //返回该直播间最近的一条长视频数据
            ShortVideo video = videos.get(0);
            return video;
        }
        return null;
    }

}
