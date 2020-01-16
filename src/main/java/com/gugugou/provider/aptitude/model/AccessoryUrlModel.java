package com.gugugou.provider.aptitude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: AccessoryUrl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 16:37
 */
@Data
@ToString
@Excel("附件表")
public class AccessoryUrlModel implements Serializable {

    private static final long serialVersionUID = -757239143721427513L;
    /** 主键id */
    @ExcelField("数据条数")
    private Long id ;
    /** 品牌资质外键id */
    private Long brandIdFk ;
    /** 违规处罚表外键id */
    private Long violationsIdFk ;
    /** 供应商资质表外键id */
    private Long providerAptitudeIdFk ;
    /** 附件路径 */
    @ExcelField("附件路径")
    private String accessoryUrl ;
    /** 附件名称 */
    @ExcelField("附件名称")
    private String accessoryName ;
    /** 附件来源;0:资质信息,1:品牌资质 */
    private Integer accessorySource ;
    /** 附件位置 */
    private Integer accessoryAddress ;
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
