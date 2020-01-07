package com.gugugou.provider.commodity.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: SkuPathRequestDTO
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/6 14:06
 */
@Data
public class SkuPathResponseDTO implements Serializable {

    /** 主键id */
    private Long id ;
    /** sku_id */
    private Long skuId ;
    /** 供应商id */
    private Long providerId;
    /** 供应商名称 */
    private String providerName;
    /** 路径id */
    private Long pathId;
    /** 路径类型 */
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
