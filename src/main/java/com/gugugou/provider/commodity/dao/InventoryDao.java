package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.InventoryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: InventoryDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/9 16:01
 */
public interface InventoryDao {

    /**
     * 新增库存
     * @param inventoryModel
     * @return
     */
    Long insertInventory(InventoryModel inventoryModel);

    /**
     * 根据skuId和仓库编码，查询可用库存
     * @param inventoryModel
     * @return
     */
    InventoryModel selectRealQuantityBySkuIdAndWareHouse(InventoryModel inventoryModel);

    /**
     * 根据路径id和skuId查询所有路径库存数据条数
     * @param inventoryModel
     * @return
     */
    Long selectPathRealQuantityCountBySkuIdAndPathId(InventoryModel inventoryModel);

    /**
     * 根据路径id和skuId查询所有路径库存数据
     * @param inventoryModel
     * @return
     */
    List<InventoryModel> selectPathRealQuantityBySkuIdAndPathId(InventoryModel inventoryModel);

    /**
     * 设置路径库存
     * @param inventoryModel
     * @return
     */
    int updatePathRealQuantity(InventoryModel inventoryModel);

}
