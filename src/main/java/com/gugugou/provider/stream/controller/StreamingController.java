package com.gugugou.provider.stream.controller;

import com.gugugou.provider.stream.model.*;
import com.gugugou.provider.stream.service.StreamingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("streaming")
@RestController
public class StreamingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private StreamingService streamingService;

    /**添加直播间*/
    @RequestMapping("addStreaming")
    public int addStreaming(@RequestBody Streaming streaming){
        return  streamingService.addStreaming(streaming);
    }

    /**修改直播间*/
    @RequestMapping("updateStreaming")
    public int updateStreaiming(@RequestBody Streaming streaming){
        return  streamingService.updateStreaming(streaming);
    }

    /**展示直播间列表*/
    @RequestMapping("AllStreamings")
     public List<Streaming> allStreamings(@RequestParam String  anchorName){
        return streamingService.allStreamings(anchorName);
    }

    /**直播间排班添加*/
    @RequestMapping("arrange")
    public int arrangeStreaming(@RequestBody ArrangeStreaming arrangeStreaming){
         return streamingService.addWorkingSchedule(arrangeStreaming);
    }

    /**编辑排班直播间的信息*/
    @RequestMapping("updateArrange")
    public int updateArrange(@RequestBody ArrangeStreaming arrangeStreaming){
        return streamingService.updateArrange(arrangeStreaming);
    }


    /**展示所有排班直播间和关联商品的数量*/
    @PostMapping("arrangeList")
    public Map arrangeLists(@RequestBody ArrangeStreaming arrangeStreaming){
         return  streamingService.findArrangeList(arrangeStreaming);
    }

    /**排班直播间解冻*/
    @PostMapping("updateStatus")
    public int updatedStatus(@RequestBody ArrangeStreaming arrangeStreaming){
        return streamingService.updatedStatus(arrangeStreaming);
    }

    /**排班直播间冻结*/
    @PostMapping("updateArrangeStatus")
    public int updateArrangeStatus(@RequestBody ArrangeStreaming arrangeStreaming){
        return streamingService.updateArrangeStatus(arrangeStreaming);
    }

    /**添加长视频*/
    @PostMapping("longVideo")
    public int addLongVideo(@RequestBody ShortVideo longVideo){
        return  streamingService.addLongVideo(longVideo);
    }

    /**展示排班间的录播列表*/
    @PostMapping("showStreamingRecorded")
    public List<ShortVideo> showStreamingRecorded(@RequestBody ShortVideo shortVideo){
          return  streamingService.showStreamingRecorded(shortVideo);
    }

    /**排班表中的复制录播链接*/
    @RequestMapping("streamingCopyUrl")
    public String findLongVideo(@RequestBody ShortVideo longVideo){
        return streamingService.findLongVideo(longVideo);
    }

    /**添加短视频*/
    @PostMapping("shortVideo")
    public int addShortVideo(@RequestBody ShortVideo shortVideo){
        return streamingService.addShortVideo(shortVideo);
    }

    /**录播管理查找短视频*/
    @PostMapping("findShortVideo")
    public Map findShortVideo(@RequestBody ShortVideo shortVideo){
        return  streamingService.findShortVideo(shortVideo);
    }

    /**添加直播间的评论*/
    @RequestMapping("addComment")
    public int addComment(@RequestBody StreamingComment streamingComment){
        return  streamingService.addComment(streamingComment);
    }

    /**根据排班表id和开始结束时间查看所有评论*/
    @PostMapping("findAllCommentById")
    public Map findAllComment(@RequestBody ShortVideo longVideo){
        return  streamingService.findAllCommentById(longVideo);
    }

    /**???禁言(待定没有找到用户表)*/
    @RequestMapping("updateCommentStatus")
    public int updateCommentStatus(@RequestBody StreamingComment streamingComment){
        return streamingService.updateCommentStatus(streamingComment);
    }

    /**录播管理复制短视频链接(根据短视频id)*/
    @PostMapping("copyUrl")
    public ShortVideo copyUrl(@RequestBody ShortVideo shortVideo){
        return streamingService.copyUrl(shortVideo.getId());
    }

    /**根据id返现短视频及商品*/
    @PostMapping("findShortById")
    public ShortVideo findShortById(@RequestBody ShortVideo shortVideo){
        return  streamingService.findShortById(shortVideo.getId());
    }

    /**短视频中商品的编辑*/
    @RequestMapping("updatedShop")
    public int updatedShop(@RequestBody ShortVideo shortVideo){
        return  streamingService.updatedShop(shortVideo);
    }

    /**直播间查找商品*/
    @RequestMapping("findStreamingShop")
    public List<Commodity> findStreamingShop(@RequestBody FindStreamingShop findStreamingShop){
        return  streamingService.findStreamingShop(findStreamingShop);
    }

    /**短视频删除*/
    @PostMapping("deleteShopVideo")
    public int deleteShortVideo(@RequestBody ShortVideo video){
        return streamingService.deleteShortVideo(video.getId());
    }

    /**修改短视频的上下线状态*/
    @PostMapping("changeShortStatus")
    public int changeShortStatus(@RequestBody ShortVideo shortVideo){
        return  streamingService.changeShortStatus(shortVideo);
    }

    /**售价设置(未完成)*/
    @PostMapping("setPrice")
    public int setPrice(@RequestBody PathAndPrice pathAndPrice){

        return streamingService.setPrice(pathAndPrice);
    }

    /**设置扣点(未完成)*/
    @RequestMapping("setPoints")
    public int setPoints(){

        return 1;
    }

    /**设置库存(暂时不需要做)*/
    @RequestMapping("setStock")
    public int setStock(){

        return 1;
    }

    /**查找直播路径下的商品和sku信息价格*/
   @PostMapping("streamingSkuPrice")
   public List<PathAndPrice> streamingSkuPrice(@RequestBody ArrangeStreaming arrangeStreaming){
       return streamingService.streamingSkuPrice(arrangeStreaming);
   }


    /**添加直播间的商品(从前台传过来商品及sku的集合)*/
    @RequestMapping("saveShop")
    public int saveShop(@RequestBody List<ArrangeAndSku> arrangeAndSkus){
        logger.info("arrangeAndSkus:{}",arrangeAndSkus.toString());
        return  streamingService.saveShop(arrangeAndSkus);
    }


    /**展示直播间的商品名称及sku属性*/
    @GetMapping("showStreamingSku")
    public List<ArrangeAndSku> showStreamingSku(@RequestParam int id){
        long ids = id;
        return  streamingService.showStreamingSku(ids);
    }

    /**直播间售价设置*/
    @GetMapping("findStreamingSell")
    public ArrangeAndSku findStreamingSell(@RequestParam ArrangeSkuId arrangeSkuId){
          return  streamingService.findStreamingSell(arrangeSkuId);
    }

    /**直播间的商品sku的路径设置提交*/
    @PostMapping("streamingSkuPriceCommotity")
    public int addStreamingSkuPrice(@RequestBody PathAndPrice pathAndPrice){
        return streamingService.addStreamingSkuPrice(pathAndPrice);
    }

    /**直播间删除sku*/
    @PostMapping("deleteSkuId")
    public int deleteSkuId(@RequestBody ArrangeSkuId arrangeSkuId){
        return  streamingService.deleteSkuId(arrangeSkuId);
    }

    /**排班间商品上架*/
    @PostMapping("putaway")
    public int putaway(@RequestBody ArrangeAndSku arrangeAndSku){

        return  streamingService.putaway(arrangeAndSku);
    }

    /**排班间商品的编辑*/
    @PostMapping("shopEdit")
    public int shopEdit(@RequestBody ArrangeAndSku arrangeAndSku){
        return  streamingService.shopEdit(arrangeAndSku);
    }


}
