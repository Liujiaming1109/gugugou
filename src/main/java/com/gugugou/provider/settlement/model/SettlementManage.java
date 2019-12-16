package com.gugugou.provider.settlement.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:16
 */
@Data
@ToString
public class SettlementManage implements Serializable {
    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Long id ;
    /** 供应商id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 结算单id */
    private Long settlementId ;
    /** 应付金额 */
    private BigDecimal amountPayable ;
    /** 结算单状态 */
    private Integer settlementStatus ;
    /** 付款订单分账金额 */
    private BigDecimal paymentOrderPrice ;
    /** 退款订单分账金额 */
    private BigDecimal refundOrderPrice ;
    /** 违规处罚金额 */
    private BigDecimal violationsPrice ;
    /** 结算开始时间 */
    private Date settlementBeginTime ;
    /** 结算结束时间 */
    private Date settlementEndTime ;
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
