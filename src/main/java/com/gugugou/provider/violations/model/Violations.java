package com.gugugou.provider.violations.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Violations implements Serializable {
    /** 主键id */
    private Integer id ;
    /** 供应商外键id */
    private Integer providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 处罚类型 */
    private String punishType ;
    /** 处罚商品id */
    private String punishSkuId ;
    /** 处罚金额 */
    private Double punishAmount ;
    /** 处罚状态;0:已结算,1:待结算(默认) */
    private Integer punishStatus ;
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
