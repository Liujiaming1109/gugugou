package com.gugugou.provider.settlement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: FinancialCollectingExcel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/17 15:51
 */
@Data
@Excel("财务分账表")
public class FinancialCollectingExcel implements Serializable {
    private static final long serialVersionUID = -5847981693927915236L;


    /** 结算单行数据 */
    /** 主订单号 */
    @ExcelField("主订单号")
    private Long orderId ;
    /** 子订单号 */
    @ExcelField("子订单号")
    private Long subOrderId ;
    /** 订单支付日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderPaymentTime ;
    @ExcelField("订单支付日期")
    private String orderPaymentTimeExcel;
    /** 订单交易成功日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderSuccessfulTime ;
    @ExcelField("订单交易成功日期")
    private String orderSuccessfulTimeExcel;
    /** 供应商id */
    @ExcelField("供应商ID")
    private Long providerId ;
    /** 供应商名称 */
    @ExcelField("供应商名称")
    private String providerName ;
    /**路径名称   用来筛选财务分账的结算单行数据（结算单库不存，结算单行要存）*/
    @Transient
    @ExcelField("结算路径")
    private String pathName;
    /** 结算单状态 */
    private Integer settlementStatus ;
    @ExcelField("结算单状态")
    private String settlementStatusExcel;
    /** 商品id */
    @ExcelField("商品ID")
    private Long skuId ;
    /** 商品名称 */
    @ExcelField("商品名称")
    private String skuName ;
    /** 商品原价 */
    @ExcelField("原价（元）")
    private BigDecimal skuOriginalPrice ;
    /** 实付单价 */
    @ExcelField("实付单价（元）")
    private BigDecimal actualPaymentPrice ;
    /** 交易成功数量 */
    @ExcelField("交易成功数量")
    private Integer tradeSuccessfulNumber ;
    /** 原价销售额 */
    @ExcelField("原价销售额")
    private BigDecimal originalPriceSales ;
    @ExcelField("实际销售额")
    private BigDecimal actualPriceSales;
    /** 扣点 */
    @ExcelField("扣点")
    private double bucklePoint ;
    /** 结算金额 */
    @ExcelField("结算金额")
    private BigDecimal settlementAmount ;

}
