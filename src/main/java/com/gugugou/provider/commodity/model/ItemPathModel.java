package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: ItemPathModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/7 21:19
 */
@Data
public class ItemPathModel implements Serializable{

    private static final long serialVersionUID = 4195700384582135413L;
    /** 主键id */
    private Long id ;
    /** 商品外键id */
    private Long itemId ;
    /** 路径id */
    private Long pathId ;
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
