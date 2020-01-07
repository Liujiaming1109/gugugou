package com.gugugou.provider.commodity.service;

import com.gugugou.provider.commodity.model.WarehouseProviderModel;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderService
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 11:17
 */
public interface WarehouseProviderService {

    /**
     * 添加供应商和仓库关系
     * @param inventoryProviderModel
     * @return
     */
    Integer addWarehouseProvider(WarehouseProviderModel inventoryProviderModel);

    /**
     * 根据仓库id查询供应商关系
     * @param id
     * @return
     */
    WarehouseProviderModel selectWarehouseProviderById(Long id);

    /**
     * 修改供应商仓库关系
     * @param inventoryProviderModel
     * @return
     */
    Integer updateWarehouseProviderById(WarehouseProviderModel inventoryProviderModel);
}
