package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gugugou.provider.commodity.DTO.RequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: Entrepot
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/12 13:51
 */
@Data
@ToString
public class EntrepotModel extends RequestDTO {

    private static final long serialVersionUID = 6817033657063187748L;
    /** 主键id */
    private Long id ;
    /** 供应商外键id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 仓库名称 */
    private String entrepotName ;
    /** 收货地址 */
    private String address ;
    /** 仓库经纬度 */
    private String entrepotLatitude ;
    /** 物理库存 */
    private Integer physicalInventory ;
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
    /** 逻辑删除 */
    private Integer removed ;
}
