package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 排班表与商品的中间表*/

@Data
@ToString
public class ArrangeAndSku implements Serializable {
    /**主键id*/
    private Long id;

    /**排班间id*/
    private Long arrangeRoomId;

    /**商品id*/
    private Long itemId;

    /**商品名称*/
    private String name;

    /**skuid集合*/
    private List<ArrangeAndSkuFk> Commtitys;

    /**商品的排列顺序*/
    private int order;

    /**商品上下线状态*/
    private int status;

    /**库存*/
    private int inventory;

    /**实时库存*/
    private int realInventory;

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
