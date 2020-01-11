package com.gugugou.provider.path.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: ItemPathSkuDTO
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/9 20:57
 */
@Data
public class ItemPathSkuDTO implements Serializable {

    private static final long serialVersionUID = 4956834798334147210L;
    /** 主键id */
    private Long id ;
    /** 商品外键id */
    private Long itemId ;
    /** 路径id */
    private Long pathId ;
    /** skuId */
    private Long skuId ;
    /** 商品路径表外键id */
    private Long itemPathId ;
    /** 路径价格 */
    private Integer pathPrice ;
}
