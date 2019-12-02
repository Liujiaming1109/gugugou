package com.gugugou.provider.aptitude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: BrandModel
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 14:39
 */
@Data
@ToString
public class BrandModel {

    /** 主键id */
    private Integer id ;
    /** 品牌名称 */
    private String brandName ;
    /** 类目id */
    private String typeId ;
    /** 类目名称 */
    private String type ;
    /** 供应商外键id */
    private Integer providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 供应商授权等级 */
    private Integer providerAuthLevel ;
    /** 资质状态 */
    private Integer aptitudeStatus ;
    /** 商标授权书生效日期 */
    private Date trademarkStartDate ;
    /** 商标授权书到期日期 */
    private String trademarkEndDate ;
    /** 品牌介绍 */
    private String brandIntroduce ;
    /** 贸易方式 */
    private Integer tradeType ;
    /** 扣点 */
    private String bucklePoint ;
    /** 派单权重 */
    private String sendOrderWeight ;
    /** 商标注册证生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date trademarkRegisterStartDate ;
    /** 商标注册证到期日期 */
    private String trademarkRegisterEndDate ;
    /** 生产商委托加工协议生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date producerDealStartDate ;
    /** 生产商委托加工协议到期日期 */
    private String producerDealEndDate ;
    /** 商品卫生证书生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date healthCertificateStartDate ;
    /** 商品卫生证书到期日期 */
    private String healthCertificateEndDate ;
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
