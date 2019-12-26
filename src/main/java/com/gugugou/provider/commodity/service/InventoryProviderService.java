package com.gugugou.provider.commodity.service;

import com.gugugou.provider.commodity.model.InventoryProviderModel;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderService
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 11:17
 */
public interface InventoryProviderService {

    Integer addInventoryProvider(InventoryProviderModel inventoryProviderModel);

    InventoryProviderModel selectInventoryProviderById(Long id);

    Integer updateInventoryProviderById(InventoryProviderModel inventoryProviderModel);
}
