package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class PathAndPrice implements Serializable {

    /**主键id*/
    private Long id;

    /**skuid*/
    private Long skuId;

    /**路径Id*/
    private Long itemPathId;

    /**路径价格*/
    private int pathPrice;

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
