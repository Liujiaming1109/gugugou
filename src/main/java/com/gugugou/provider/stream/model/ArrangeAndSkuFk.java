package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
/**
 * 排班表下的sku表*/


@Data
@ToString
public class ArrangeAndSkuFk implements Serializable {
    /**主键id*/
    private Long id;

    /**排班表id*/
    private Long arrangeSkuId;

    /**skuid*/
    private Long commotityId;

    /**商品的id*/
    private Long itemId;

    /**供应商的数量*/
    private int providerCount;

    /**仓库的数量*/
    private int warehouseCount;

    /**总库存*/
    private int skuCount;

    /**实时库存*/
    private int realInventory;

    /**直播间sku直播售价*/
    private int streamingSellPrice;

    /**逻辑删除*/
    private int removed;

}
