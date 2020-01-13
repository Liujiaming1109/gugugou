package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class SkuAndPath implements Serializable {

    /**主键id*/
    private Long id;

    /**skuid*/
    private Long skuId;

    /**供应商id*/
    private Long providerId;

    /**商品路径id*/
    private Long itemPathId;

    /**扣点*/
    private int point;

    /**创建人*/
    private String createdBy;

    /**创建时间*/
    private Date createdTime;

    /**修改人*/
    private String updatedBy;

    /**修改时间*/
    private Date updatedTime;

    /**逻辑删除*/
    private int removed;
}
