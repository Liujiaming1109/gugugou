package com.gugugou.provider.provider.model;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class InformationContact implements Serializable {

    /**主键id*/
    private Long id;
    /**供应商id*/
    private Long providerIdFk;
    /**联系人类别 0:负责人,1:对接人,2:物流联系人,3:退货对接人*/
    private String contactType;
    /**联系人姓名*/
    private String contactName;
    /**联系人手机*/
    private String contactPhone;
    /**联系人邮件*/
    private String contactEmail;
    /**联系人钉钉*/
    private String contactDingding;
    /*创建人*/
    private String createdBy;
    /*创建时间*/
    private Date createdTime;
    /*更新人*/
    private String updatedBy;
    /*更新时间*/
    private Date updatedTime;
    /*逻辑删除*/
    private int removed;
}
