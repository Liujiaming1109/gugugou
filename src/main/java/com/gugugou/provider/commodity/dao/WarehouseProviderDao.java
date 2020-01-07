package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.WarehouseProviderModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 10:26
 */
@Mapper
public interface WarehouseProviderDao {

    /**
     * 添加供应商和仓库关系
     * @param inventoryProviderModel
     * @return
     */
    int addWarehouseProvider(WarehouseProviderModel inventoryProviderModel);

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
    int updateWarehouseProviderById(WarehouseProviderModel inventoryProviderModel);
}
