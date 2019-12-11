package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: PathModel
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/11 12:00
 */
@Data
@ToString
public class PathModel implements Serializable {

    private static final long serialVersionUID = -7640037051344379096L;
    /** 主键id */
    private Integer id ;
    /** 路径名称 */
    private String pathName ;
    /** 路径状态 */
    private String pathStatus ;
    /** 路径有效期 */
    private String pathValidity ;
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
    /** 逻辑删除(0：正常，1:删除) */
    private Integer removed ;
}
