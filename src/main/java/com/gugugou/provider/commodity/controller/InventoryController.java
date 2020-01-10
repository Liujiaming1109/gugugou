package com.gugugou.provider.commodity.controller;

import com.gugugou.provider.commodity.model.InventoryModel;
import com.gugugou.provider.commodity.service.InventoryService;
import com.gugugou.provider.common.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: InventoryController
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/9 19:47
 */
@RequestMapping("commodity/inventory")
@RestController
public class InventoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private InventoryService inventoryService;

    /**
     * 根据路径id和skuId查询所有路径库存数据
     * @param inventoryModel
     * @return
     */
    @PostMapping("selectRealQuantityBySkuIdAndWareHouse")
    public ResponseDTO selectPathRealQuantityBySkuIdAndPathId(@RequestBody InventoryModel inventoryModel) {
        logger.info("根据路径id和skuId查询所有路径库存数据的入参--inventoryModel:：{}", inventoryModel);
        return inventoryService.selectPathRealQuantityBySkuIdAndPathId(inventoryModel);
    }

    /**
     * 设置路径库存
     * @param inventoryModel
     * @return
     */
    @PostMapping("updatePathRealQuantity")
    public Integer updatePathRealQuantity(InventoryModel inventoryModel) {
        logger.info("设置路径库存的入参--inventoryModel：{}", inventoryModel);
        return inventoryService.updatePathRealQuantity(inventoryModel);
    }
}
