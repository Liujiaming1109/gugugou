package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.WarehouseProviderModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 10:26
 */
@Mapper
public interface WarehouseProviderDao {

    List<WarehouseProviderModel> selectWareHouseByProvider(Long id);
}
