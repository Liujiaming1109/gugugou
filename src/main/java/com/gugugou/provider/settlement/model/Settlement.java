package com.gugugou.provider.settlement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:18
 */
@Data
@ToString
public class Settlement implements Serializable {

    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Long id ;

    /** 供应商id */
    private Long providerId ;
    /** 供应商名称 */
    private String providerName ;

    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date settlementTime ;
    /** 结算开始时间 */
    //标记非数据库字段
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date settlementBeginTime ;
    /** 结算结束时间 */
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date settlementEndTime ;
    /**路径名称   用来筛选财务分账的结算单行数据（结算单库不存，结算单行要存）*/
    @Transient
    private String pathName;
    /** 结算周期 */
    private String settlementCycle ;
    /** 结算金额 */
    private BigDecimal settlementAmount ;
    /** 结算单状态 */
    private Integer settlementStatus ;
    /** 汇总 */
    private BigDecimal summary ;
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

    /**结算单编号*/
    private String settlementCode;

    /** 结算单行数据 */
    private List<SettlementLine> settlementLines;
}
