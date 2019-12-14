package com.gugugou.provider.violations.model;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Violations implements Serializable {

    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Long id ;
    /** 供应商外键id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 处罚类型 */
    private String punishType ;
    /** 处罚商品id */
    private Long punishSkuId ;
    /** 处罚金额 */
    private BigDecimal punishAmount ;
    /** 处罚状态;0:已结算,1:待结算(默认) */
    private Integer punishStatus ;
    /** 违规时间 */
    private Date violationsTime ;
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
    /**附件集合*/
    private List<AccessoryUrlModel> accessoryList;
}
