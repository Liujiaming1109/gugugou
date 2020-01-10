package com.gugugou.provider.commodity.service;

import com.gugugou.provider.commodity.model.InventoryModel;
import com.gugugou.provider.common.ResponseDTO;

/**
 * @author: chengShaoShao
 * @Title: InventoryService
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/9 17:49
 */
public interface InventoryService {

    /**
     * 根据路径id和skuId查询所有路径库存数据
     * @param inventoryModel
     * @return
     */
    ResponseDTO selectPathRealQuantityBySkuIdAndPathId(InventoryModel inventoryModel);

    /**
     * 设置路径库存
     * @param inventoryModel
     * @return
     */
    Integer updatePathRealQuantity(InventoryModel inventoryModel);
}
