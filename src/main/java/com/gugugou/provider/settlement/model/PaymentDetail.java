package com.gugugou.provider.settlement.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:32
 */
@Data
@ToString
public class PaymentDetail implements Serializable {
    /** 主键id */
    private Long id ;
    /** 供应商id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 主订单号 */
    private Long mainOrderId ;
    /** 子订单号 */
    private Long subOrderId ;
    /** 订单支付日期 */
    private Date orderPaymentTime ;
    /** 订单交易成功日期 */
    private Date orderSuccessfulTime ;
    /** 商品id */
    private Long skuId ;
    /** 商品名称 */
    private String skuName ;
    /** 结算渠道 */
    private Integer settlementChannel ;
    /** 商品原价 */
    private BigDecimal skuOriginalPrice ;
    /** 实际结算价 */
    private BigDecimal actualSettlementPrice ;
    /** 正向数量 */
    private Integer positiveNumber ;
    /** 扣点 */
    private Integer bucklePoint ;
    /** 分账金额 */
    private BigDecimal fashionableAmount ;
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
