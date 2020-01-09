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

    Long insertInventory(InventoryModel inventoryModel);

    /**
     * 根据skuId和仓库编码，查询可用库存
     * @param wareHouseCode
     * @param entityId
     * @return
     */
    InventoryModel selectRealQuantityBySkuIdAndWareHouse(@Param("warehouseCode") Long wareHouseCode, @Param("entityId") Long entityId);

    /**
     * 根据路径id和skuId查询所有路径库存数据
     * @param pathId
     * @param entityId
     * @return
     */
    List<InventoryModel> selectPathRealQuantityBySkuIdAndPathId(@Param("pathId") Long pathId, @Param("entityId") Long entityId);

}
