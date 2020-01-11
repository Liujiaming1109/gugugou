package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

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

    private static final long serialVersionUID = -7188015607877234263L;
    private Long providerId;
    /**
     * 编码
     */
    private String warehouseCode;

    /**
     * 名称
     */
    private String warehouseName;

    /**
     * 类型
     */
    private Integer warehouseType;

    /**
     * priority
     */
    private Integer priority;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否默认仓库
     */
    private Integer isDefault;

    /**
     * 省市区Id
     */
    private String divisionId;

    /**
     * 区域
     */
    private String regionId;

    /**
     *  状态
     */
    private Integer status ;

    /**
     *  外部编号
     */
    private String outerCode;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    @Getter
    @Setter
    private Long id;

    /**
     * 租户Id
     */
    @Getter
    @Setter
    private Integer tenantId;

    /**
     * 额外信息,持久化到数据库
     */
    @JsonIgnore
    @Getter
    protected String extraJson;

    /**
     * 额外信息,不持久化到数据库
     */
    @Getter
    protected Map<String, String> extra;

    @Getter
    @Setter
    private String updatedBy;
}
