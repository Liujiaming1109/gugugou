package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 直播间查找商品条件*/
@Data
@ToString
public class FindStreamingShop implements Serializable{

    /**商品id*/
    private Long commodityId;

    /**品牌名称*/
    private String brandName;

    /**类目名称*/
    private String typeName;

    /**商品名称*/
    private String name;

    /**价格*/
    private String commodityPrice;

    /**状态*/
    private int status;

    /**SKU编码*/
    private String skuCode;

    /**库存*/
    private String realQuantity;

    /**排班表的id*/
    private Long anchorId;

}
