package com.gugugou.provider.aptitude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: BrandModel
 * @ProjectName: provider
 * @Description: 供应商-品牌资质表
 * @date 2019/12/2 14:39
 */
@Data
@ToString
public class BrandModel implements Serializable {

    private static final long serialVersionUID = 4627214355439548702L;
    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    /** 主键id */
    private Long id ;
    /** 品牌id */
    private Long brandId ;
    /** 品牌名称 */
    private String brandName ;
    /** 类目id */
    private Long typeId ;
    /** 类目名称 */
    private String typeName ;
    /** 供应商外键id */
    private Integer providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
    /** 供应商授权等级 */
    private Integer providerAuthLevel ;
    /** 资质状态 */
    private Integer trademarkStatus ;
    /** 商标授权书生效日期 */
    private Date trademarkStartDate ;
    /** 商标授权书到期日期 */
    private String trademarkEndDate ;
    /** 品牌介绍 */
    private String brandIntroduce ;
    /** 贸易方式 */
    private Integer tradeType ;
    /** 扣点 */
    private Integer bucklePoint ;
    /** 派单权重 */
    private Integer sendOrderWeight ;
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

    /**
     * 商标权人出具的授权书附件
     */
    private List<AccessoryUrlModel> trademarkList;
    /**
     * 商标注册证附件
     */
    private List<AccessoryUrlModel> registerList;
    /**
     * 检测报告附件
     */
    private List<AccessoryUrlModel> examiningReportList;
    /**
     *产品清单附件
     */
    private List<AccessoryUrlModel> productList;
    /**
     * 非食品品牌生产厂商还需要同时提供《食品经营许可证》或 《食品流通许可证》附件
     */
    private List<AccessoryUrlModel> foodManufacturerList;
    /**
     * 生产厂商的《食品生产许可证》&产品涉及委托加工，需同时提供与生产厂商间的委托加工协议
     */
    private List<AccessoryUrlModel> processManufacturerList;
    /**
     * 《商品出入境检验检疫卫生证书》或《商品出入境检验检疫卫生证明》
     */
    private List<AccessoryUrlModel> exitAndEntryList;
    /**
     * 《食盐批发[含转(代)批发]许可证》
     */
    private List<AccessoryUrlModel> saltList;
    /**
     * 中华人民共和国海关进口货物报关单
     */
    private List<AccessoryUrlModel> importList;
    /**
     * 清真食品认证（国际Halal认证）
     */
    private List<AccessoryUrlModel> halalFoodList;
    /**
     * 有机食品认证
     */
    private List<AccessoryUrlModel> organicFoodList;
    /**
     * 贵司近3个月内向上一级经销商的进货发票复印件，且发票需体现此次申请的品牌名称。
     */
    private List<AccessoryUrlModel> invoiceList;
}
