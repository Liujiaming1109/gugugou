package com.gugugou.provider.settlement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 营销明细
 * @author: yuelitao
 * @date 2020/1/15 19:03
 */
@Data
public class MarketingDetail implements Serializable{

    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Long id;
    /** 供应商id */
    private Long providerId ;
    /** 供应商名称 */
    private String providerName ;
    /** 主订单号 */
    private Long orderId ;
    /** 子订单号 */
    private Long subOrderId ;
    /**订单支付日期*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderPaymentTime ;
    /** 订单交易成功日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderSuccessfulTime ;
    /** 商品id */
    private Long skuId ;
    /** 商品名称 */
    private String skuName ;
    /**活动名称*/
    private String activityName;
    /**营销类型*/
    private String marketingType;
    /**营销费用*/
    private BigDecimal marketingAmount;
    /**实际售出数量*/
    private Integer tradeSuccessfulNumber;
    /**营销总费用*/
    private BigDecimal totalMarketingAmount;
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

    /**开始时间*/
    //标记非数据库字段
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date beginTime;

    /**结束时间*/
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endTime;
}
