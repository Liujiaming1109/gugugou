package com.gugugou.provider.provider.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: providerModel
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 13:30
 */
@Data
@ToString
public class ProviderModel {

    /** 主键id */
    private Integer id ;
    /** 品牌id */
    private Integer brandId ;
    /** 品牌名称 */
    private String brandName ;
    /** 类目 */
    private String type ;
    /** 供应商id */
    private Integer providerId ;
    /** 供应商名称 */
    private String providerName ;
    /** 经营状态 */
    private String manageStatus ;
    /** 经营方式 */
    private Integer manageMethod ;
    /** 扣点 */
    private String bucklePoint ;
    /** 派单权重 */
    private String sendOrderWeight ;
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
