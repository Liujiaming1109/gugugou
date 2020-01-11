package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class SellSet implements Serializable {

    /**路径名称*/
    private String skuName;

    /**sku销售价格*/
    private int price;
}
