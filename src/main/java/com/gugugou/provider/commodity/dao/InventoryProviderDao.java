package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.InventoryProviderModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 10:26
 */
@Mapper
public interface InventoryProviderDao {

    int addInventoryProvider(InventoryProviderModel inventoryProviderModel);

    InventoryProviderModel selectInventoryProviderById(Long id);

    int updateInventoryProviderById(InventoryProviderModel inventoryProviderModel);
}
