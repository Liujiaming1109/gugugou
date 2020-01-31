package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gugugou.provider.common.RequestDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: IconModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/31 13:31
 */
@Data
public class IconModel extends RequestDTO {

    private static final long serialVersionUID = 676432316881744721L;
    /** 主键id */
    private Long id ;
    /** 导购名称 */
    private String guideName ;
    /** logo路径 */
    private String logoUrl ;
    /** logo类型 */
    private String logoType ;
    /** logo状态 */
    private Integer logoStatus ;
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
    /** 逻辑删除（0：正常，1：删除） */
    private Integer removed ;

}
