package com.gugugou.provider.stream.controller;

import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;

import com.gugugou.provider.commodity.model.SkuPathModel;
import com.gugugou.provider.common.ResponseDTO;

import com.gugugou.provider.stream.service.StreamingSkuPathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("streamingsku")
@RestController
public class StreamingSkuPathController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

     @Resource
     private StreamingSkuPathService streamingSkuPathService;

     /**直播间商品sku设置扣点*/
     @PostMapping("updateStreamingSkuPath")
     public int updateStreamingSkuPath(@RequestBody SkuPathModel skuPathModel){
         logger.info("设置扣点的入参--skuPathModel：{}", skuPathModel);
         return streamingSkuPathService.updateStreamingSkuPath(skuPathModel);
     }

    /**
     * 批量修改扣点
     * @param updateSkuPathListRequest
     * @return
     */
    @PostMapping("updateSkuPointList")
    public Integer updateSkuPointList(@RequestBody UpdateSkuPathListRequest updateSkuPathListRequest) {
        logger.info("批量修改扣点的入参--updateSkuPathListRequest：{}", updateSkuPathListRequest);
        return streamingSkuPathService.updateStreamingkuPointList(updateSkuPathListRequest);
    }

    /**
     *查找路径下扣点列表
     * */
    @PostMapping("findStreamingSkuPoints")
    public ResponseDTO findStreamingSkuPoints(@RequestBody SkuPathModel skuPathModel){
        logger.info("批量修改扣点的入参--skuPathModel：{}", skuPathModel);
        return  streamingSkuPathService.findStreamingSkuPoints(skuPathModel);
    }


    /**查询设置库存改sku下*/
   /* @PostMapping("findStreamingInventorys")
     public ResponseDTO selecStreamingPath(@RequestBody InventoryModel inventoryModel) {
        logger.info("根据路径id和skuId查询所有路径库存数据的入参--inventoryModel:：{}", inventoryModel);
        return streamingSkuPathService.selecStreamingPath(inventoryModel);
    }*/










}
