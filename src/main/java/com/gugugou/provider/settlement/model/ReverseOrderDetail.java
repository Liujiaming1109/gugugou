package com.gugugou.provider.settlement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;

/**
 * 逆向单明细
 * @author: yuelitao
 * @date 2020/1/17 10:40
 */
@Data
@Excel("退货订单查询明细")
public class ReverseOrderDetail implements Serializable {

    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Integer id ;
    /** 主订单号 */
    @ExcelField("主订单号")
    private Integer orderId ;
    /** 子订单号 */
    @ExcelField("子订单号")
    private Integer orderLineId ;
    /** 退款编号 */
    @ExcelField("退款编号")
    private String refundSerialNo ;
    /** 订单支付日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date payAt ;
    @ExcelField("订单支付日期")
    private String payAtExcel;
    /** 订单完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date accomplishAt ;
    @ExcelField("订单完成日期")
    private String accomplishAtExcel;
    /** 退款完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date refundAt ;
    @ExcelField("退款完成日期")
    private String refundAtExcel;
    /** 商品id */
    @ExcelField("商品ID")
    private Integer itemId ;
    /** 商品名称 */
    @ExcelField("商品名称")
    private String itemName ;
    /** 实际退款金额 */
    @ExcelField("实际退款金额")
    private Double actualRefundAmount ;
    /** 路径id */
    private Integer pathId ;
    /** 路径名称 */
    @ExcelField("路径名称")
    private String pathName ;
    /** 供应商id */
    private Long providerId ;
    /** 供应商名称 */
    private String providerName ;
    /** 退货数量 */
    @ExcelField("退货数量")
    private Integer quantity ;
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

    /**逻辑删除*/
    private Integer removed;

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
