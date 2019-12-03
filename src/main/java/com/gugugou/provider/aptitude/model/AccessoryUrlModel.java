package com.gugugou.provider.aptitude.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: AccessoryUrl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 16:37
 */
public class AccessoryUrlModel implements Serializable {

    private static final long serialVersionUID = -2642010022034420197L;
    /** 主键id */
    private Integer id ;
    /** 供应商外键id */
    private Integer tProviderFk ;
    /** 附件路径 */
    private String accessoryUrl ;
    /** 附件名称 */
    private String accessoryName ;
    /** 附件来源;0:资质信息,1:品牌资质 */
    private String accessorySource ;
    /** 附件位置 */
    private String accessoryAddress ;
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
