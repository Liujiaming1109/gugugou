package com.gugugou.provider.settlement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuelitao
 * @date 2020/1/9 14:49
 */
@Data
public class SettlementLine implements Serializable {
    /** 主键id */
    private Long id;
    /** 结算单id */
    private Long settlementId;
    /** 主订单号 */
    private Long orderId ;
    /** 子订单号 */
    private Long subOrderId ;
    /** 订单支付日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderPaymentTime ;
    /** 订单交易成功日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderSuccessfulTime ;
    /** 商品id */
    private Long skuId ;
    /** 商品名称 */
    private String skuName ;
    /** 商品原价 */
    private BigDecimal skuOriginalPrice ;
    /** 实付单价 */
    private BigDecimal actualPaymentPrice ;
    /** 交易成功数量 */
    private Integer tradeSuccessfulNumber ;
    /** 原价销售额 */
    private BigDecimal originalPriceSales ;
    /** 实际销售额 */
    private BigDecimal actualPriceSales ;
    /** 路径 */
    private Long pathId ;
    /** 扣点 */
    private double bucklePoint ;
    /** 结算金额 */
    private BigDecimal settlementAmount ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updatedTime ;
    /** 逻辑删除 */
    private Integer removed ;
    /**路径名称*/
    private String pathName;
}
