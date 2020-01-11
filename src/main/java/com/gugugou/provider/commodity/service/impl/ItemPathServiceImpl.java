package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.commodity.dao.*;
import com.gugugou.provider.commodity.dto.request.AddCommodityRequest;
import com.gugugou.provider.commodity.dto.response.ItemResponse;
import com.gugugou.provider.commodity.model.*;
import com.gugugou.provider.commodity.service.ItemPathService;
import com.gugugou.provider.common.ProviderCentreConsts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: ItemPathServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 10:45
 */
@Service
@Transactional
public class ItemPathServiceImpl implements ItemPathService {

    @Resource
    private ItemPathDao itemPathDao;
    @Resource
    private BrandDao brandDao;
    @Resource
    private SkuPathDao skuPathDao;
    @Resource
    private PathPriceDao pathPriceDao;
    @Resource
    private InventoryDao inventoryDao;
    @Resource
    private WarehouseProviderDao warehouseProviderDao;

    /**
     * 路径添加商品
     * @param addCommodityRequest
     * @return
     */
    @Override
    public Long addPathCommodity(AddCommodityRequest addCommodityRequest) {
        InventoryModel inventoryModel = new InventoryModel();
        ItemPathModel itemPathModel = new ItemPathModel();
        SkuPathModel skuPathModel = new SkuPathModel();
        PathPriceModel pathPriceModel = new PathPriceModel();
        inventoryModel.setPathId(addCommodityRequest.getPathId());
        inventoryModel.setPathType("小程序");
        List<ItemModel> itemModelList = addCommodityRequest.getItemModelList();
        if (!itemModelList.isEmpty()) {
            for (ItemModel itemModel:itemModelList) {
                itemPathModel.setPathId(addCommodityRequest.getPathId());
                itemPathModel.setItemId(itemModel.getId());
                itemPathModel.setCreatedTime(new Date());
                itemPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                itemPathDao.insertItemPath(itemPathModel);
                //商品路径表主键
                Long id = itemPathModel.getId();
                skuPathModel.setItemPathId(id);
                pathPriceModel.setItemPathId(id);
                //主键查询商品表品牌id
                ItemResponse itemResponse = itemPathDao.selectItemBrandIdById(id);
                if (itemResponse != null) {
                    //查询该品牌下的所有供应商数据
                    List<BrandModel> brandModelList = brandDao.selectProviderByBrandId(itemResponse.getBrandId());
                    for (BrandModel brandModel:brandModelList) {
                        Long providerIdFk = brandModel.getProviderIdFk();
                        skuPathModel.setProviderId(providerIdFk);
                        //通过供应商查询仓库编码
                        List<WarehouseProviderModel> warehouseProviderModelList = warehouseProviderDao.selectWareHouseByProvider(providerIdFk);
                        if (!warehouseProviderModelList.isEmpty()) {
                            for (WarehouseProviderModel warehouseProviderModel:warehouseProviderModelList) {
                                inventoryModel.setWarehouseCode(warehouseProviderModel.getWarehouseCode());
                                inventoryModel.setRealQuantity(0L);
                                List<SkuModel> skuModelList = itemModel.getSkuModelList();
                                for (SkuModel skuModel:skuModelList) {
                                    inventoryModel.setEntityId(skuModel.getId());
                                    inventoryModel.setCreatedAt(new Date());
                                    inventoryDao.insertInventory(inventoryModel);
                                }
                            }
                        }
                        List<SkuModel> skuModelList = itemModel.getSkuModelList();
                        for (SkuModel skuModel:skuModelList) {
                            skuPathModel.setSkuId(skuModel.getId());
                            skuPathModel.setCreatedTime(new Date());
                            skuPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                            skuPathDao.insertSkuPath(skuPathModel);
                            pathPriceModel.setPathPrice(skuModel.getPrice());
                            pathPriceModel.setSkuId(skuModel.getId());
                            pathPriceModel.setCreatedTime(new Date());
                            pathPriceModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                            SkuPathModel skuPathBySkuId = skuPathDao.getSkuPathBySkuId(skuModel.getId());
                            //判断扣点有没有在原商品更改过
                            if (skuPathBySkuId != null) {
                                skuPathModel.setPoint(skuPathBySkuId.getPoint());
                            }else {
                                skuPathModel.setPoint(brandModel.getBucklePoint());
                            }
                            pathPriceDao.insertPathPrice(pathPriceModel);
                        }
                    }
                }
            }
        }

        return null;
    }
}
