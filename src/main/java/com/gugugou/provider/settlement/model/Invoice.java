package com.gugugou.provider.settlement.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuelitao
 * @date 2019/12/4 16:47
 */
@Data
@ToString
public class Invoice implements Serializable {

    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Integer id ;
    /** 供应商id */
    private Integer providerIdFk ;
    /** 发票抬头 */
    private String invoiceTitle ;
    /** 发票类型;0:增值税专用发票，1：增值税普通发票 */
    private Integer invoiceType ;
    /** 开票内容 */
    private String invoiceContent ;
    /** 开票金额 */
    private BigDecimal invoicePrice ;
    /** 开票状态 */
    private Integer invoiceStatus ;
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
