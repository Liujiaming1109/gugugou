package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.commodity.dao.WarehouseProviderDao;
import com.gugugou.provider.commodity.model.WarehouseProviderModel;
import com.gugugou.provider.commodity.service.WarehouseProviderService;
import com.gugugou.provider.common.ProviderCentreConsts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 11:18
 */
@Service
@Transactional
public class WarehouseProviderServiceImpl implements WarehouseProviderService {

    @Resource
    private WarehouseProviderDao inventoryProviderDao;

    /**
     * 添加供应商和仓库关系
     * @param inventoryProviderModel
     * @return
     */
    @Override
    public Integer addWarehouseProvider(WarehouseProviderModel inventoryProviderModel) {
        inventoryProviderModel.setCreatedTime(new Date());
        inventoryProviderModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
        return inventoryProviderDao.addWarehouseProvider(inventoryProviderModel);
    }

    /**
     * 根据仓库id查询供应商关系
     * @param id
     * @return
     */
    @Override
    public WarehouseProviderModel selectWarehouseProviderById(Long id) {
        return inventoryProviderDao.selectWarehouseProviderById(id);
    }

    /**
     * 修改供应商仓库关系
     * @param inventoryProviderModel
     * @return
     */
    @Override
    public Integer updateWarehouseProviderById(WarehouseProviderModel inventoryProviderModel) {
        inventoryProviderModel.setUpdatedTime(new Date());
        return inventoryProviderDao.updateWarehouseProviderById(inventoryProviderModel);
    }
}
