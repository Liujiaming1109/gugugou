package com.gugugou.provider.commodity.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * @author: chengShaoShao
 * @Title: Inventory
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/9 11:57
 */
@Data
public class InventoryModel implements Serializable {


    private static final long serialVersionUID = -3650810646797404464L;
    private Long providerId;

    private Long pathId;

    private String pathType;
    /**
     * entity id
     */
    private Long entityId;

    /**
     * 类型：SkuId(1), SkuCode(2)
     */
    private Integer entityType;

    /**
     * 唯一键，用于幂等
     */
    private String uniqueCode;

    /**
     * 仓库编码
     */
    private String warehouseCode;

    /**
     * 仓库类型

     */
    private Integer warehouseType;

    /**
     * 真实库存(物理库存)
     */
    private Long realQuantity;

    /**
     * 安全库存
     */
    private Long safeQuantity;

    /**
     * 在途库存(JIT)
     */
    private Long preorderQuantity;

    /**
     * 锁定库存
     */
    private Long withholdQuantity;

    /**
     * 占用库存
     */
    private Long occupyQuantity;

    /**
     * 状态：Active(1), Inactive(0)
     */
    private Integer status;

    /**
     * sku code
     */
    private String skuCode;

    /**
     * 版本号，乐观锁
     */
    private Integer version;

    /**
     * 库存同步时间
     */
    private Date syncAt;

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
