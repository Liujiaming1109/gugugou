package com.gugugou.provider.stream.dao;



import com.gugugou.provider.commodity.model.SkuPathModel;

import com.gugugou.provider.common.ResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StreamingSkuPthDao {

    /**查找sku路径中间表是否有该数据*/
    SkuPathModel getSkuPathById(SkuPathModel skuPathModel);

    /**设置排班间商品sku的扣点*/
    int updateStreamingSkuPath(SkuPathModel skuPathModel);

     /**添加排班表商品的sku的扣点*/
    void insertSkuPath(SkuPathModel skuPathModel);

    /**查找sku_path路径表下是否有这个数据*/
    SkuPathModel getStreamingSkuById(Long id);

    /**排班间商品sku批量修改扣点*/
    void updateStreamingSkuPoint(SkuPathModel skuPathModel);

    /**查找路径下的扣点列表*/
    ResponseDTO findStreamingSkuPoints(SkuPathModel skuPathModel);

    /**查询路径下的扣点列表*/
    List<SkuPathModel> selectPathPointListByPage(SkuPathModel skuPathModel);

    /**查询路径下的扣点列表的数量*/
    Long selectPathPointCountByPage(SkuPathModel skuPathModel);

    /**根据路径id和skuId查询所有路径库存数据*/
    /*ResponseDTO selecStreamingPath(InventoryModel inventoryModel);*/
}
