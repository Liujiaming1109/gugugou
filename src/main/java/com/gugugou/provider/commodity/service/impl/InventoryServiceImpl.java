package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.commodity.dao.InventoryDao;
import com.gugugou.provider.commodity.model.InventoryModel;
import com.gugugou.provider.commodity.service.InventoryService;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: InventoryServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/9 17:49
 */
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Resource
    private InventoryDao inventoryDao;

    /**
     * 根据路径id和skuId查询所有路径库存数据
     * @param inventoryModel
     * @return
     */
    @Override
    public ResponseDTO selectPathRealQuantityBySkuIdAndPathId(InventoryModel inventoryModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (inventoryModel.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*(inventoryModel.getPageSize());
        inventoryModel.setPageIndex(pageIndex);
        List<InventoryModel> inventoryModelList = inventoryDao.selectPathRealQuantityBySkuIdAndPathId(inventoryModel);
        if (!inventoryModelList.isEmpty()) {
            for (InventoryModel inventoryModels:inventoryModelList) {
                String warehouseCode = inventoryModels.getWarehouseCode();
                inventoryModel.setWarehouseCode(warehouseCode);
                InventoryModel inventoryModel1 = inventoryDao.selectRealQuantityBySkuIdAndWareHouse(inventoryModel);
                inventoryModel1.setPathQuantity(inventoryModel1.getRealQuantity());
            }
            responseDTO.setData(inventoryModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = inventoryDao.selectPathRealQuantityCountBySkuIdAndPathId(inventoryModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 设置路径库存
     * @param inventoryModel
     * @return
     */
    @Override
    public Integer updatePathRealQuantity(InventoryModel inventoryModel) {
        inventoryModel.setUpdatedAt(new Date());
       return inventoryDao.updatePathRealQuantity(inventoryModel);
    }


}
