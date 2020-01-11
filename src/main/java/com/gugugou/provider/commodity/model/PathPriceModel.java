package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: PathPriceModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 10:07
 */
@Data
public class PathPriceModel {

    /** 主键id */
    private Long id ;
    /** skuId */
    private Long skuId ;
    /** 商品路径表外键id */
    private Long itemPathId ;
    /** 路径价格 */
    private Integer pathPrice ;
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
    /** 逻辑删除（0：正常，1删除） */
    private Integer removed ;
}
