package com.gugugou.provider.commodity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gugugou.provider.common.RequestDTO;
import lombok.Data;

import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: PicModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/21 16:43
 */
@Data
public class PicModel extends RequestDTO {

    private static final long serialVersionUID = 9018300937568652474L;
    /** 主键id */
    private Long id ;
    /** 图片标题 */
    private String picTopic ;
    /** 图片类型(0：直播图片，1：广告图片，2：商城图片) */
    private Integer picType ;
    /** 图片路径 */
    private String picUrl ;
    /** 图片状态 */
    private Integer picStatus ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createdTime ;
    /** 修改人 */
    private String updatedBy ;
    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updatedTime ;
    /** 逻辑删除（0：正常，1：正常） */
    private Integer removed ;
}
