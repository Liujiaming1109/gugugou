package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: InventoryProviderModel
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/24 10:24
 */
@Data
@ToString
public class WarehouseProviderModel implements Serializable {

    private static final long serialVersionUID = -27936402014981994L;
    /** 主键id */
    private Long id ;
    /** 仓库管理表外键id */
    private Long warehouseIdFk ;
    /** 供应商外键id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
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
    /** 逻辑删除(0：正常，1:删除) */
    private Integer removed ;
}
