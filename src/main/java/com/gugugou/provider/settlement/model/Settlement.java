package com.gugugou.provider.settlement.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:18
 */
@Data
@ToString
public class Settlement implements Serializable {
    /** 主键id */
    private Long id ;
    /** 供应商id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 商品id */
    private Long skuId ;
    /** 商品名称 */
    private String skuName ;
    /** 规格型号 */
    private String specifications ;
    /** 单位 */
    private String unit ;
    /** 实际数量 */
    private Integer actualNumber ;
    /** 商品原价 */
    private BigDecimal skuOriginalPrice ;
    /** 结算金额 */
    private BigDecimal settlementAmount ;
    /** 汇总 */
    private BigDecimal summary ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;
    /** 逻辑删除 */
    private Integer removed ;
}
