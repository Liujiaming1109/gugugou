package com.gugugou.provider.path.model;

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

    private static final long serialVersionUID = 2622391529992792783L;
    /** 主键id */
    private Long id ;
    /** 路径名称 */
    private String pathName ;
    /** 路径类型 */
    private String pathType ;
    /** 路径开始时间 */
    private String pathStartTime ;
    /** 路径结束时间 */
    private String pathEndTime ;
    /** 路径状态 */
    private Integer pathStatus ;
    /** 路径开启关闭 */
    private Integer pathCloseOpen ;
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
