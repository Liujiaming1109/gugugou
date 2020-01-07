package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gugugou.provider.common.RequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: SkuPointModel
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/27 15:23
 */
@Data
@ToString
public class SkuPathModel extends RequestDTO {

    private static final long serialVersionUID = 3243459496320797838L;
    /** 主键id */
    private Long id ;
    /** sku_id */
    private Long skuId ;
    /** 供应商id*/
    private Long providerId;
    /** 路径id*/
    private Long pathId;
    /** 路径类型*/
    private String pathType;
    /** sku扣点 */
    private Integer point ;
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
