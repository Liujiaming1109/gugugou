package com.gugugou.provider.commodity.service.Impl;

import com.gugugou.provider.commodity.dao.InventoryProviderDao;
import com.gugugou.provider.commodity.model.InventoryProviderModel;
import com.gugugou.provider.commodity.service.InventoryProviderService;
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
public class InventoryProviderServiceImpl implements InventoryProviderService {

    @Resource
    private InventoryProviderDao inventoryProviderDao;

    @Override
    public Integer addInventoryProvider(InventoryProviderModel inventoryProviderModel) {
        inventoryProviderModel.setCreatedTime(new Date());
        inventoryProviderModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
        return inventoryProviderDao.addInventoryProvider(inventoryProviderModel);
    }

    @Override
    public InventoryProviderModel selectInventoryProviderById(Long id) {
        return inventoryProviderDao.selectInventoryProviderById(id);
    }

    @Override
    public Integer updateInventoryProviderById(InventoryProviderModel inventoryProviderModel) {
        inventoryProviderModel.setUpdatedTime(new Date());
        return inventoryProviderDao.updateInventoryProviderById(inventoryProviderModel);
    }
}
