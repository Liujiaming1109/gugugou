package com.gugugou.provider.provider.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Information {

    /**主键*/
    private int id;
    /**公司名称*/
    private String companyName;
    /**合同id*/
    private String contactId;
    /**合同开始时间*/
    private String contactStartDate;
    /**合同结束时间*/
    private String contactEndDate;
    /**是否续约 0:续约,1:不续约*/
    private String isContactExtension;
    /**公司地址*/
    private String companyAddress;
    /**营业执照号*/
    private String permitNumber;
    /**企业法人*/
    private String businessPeople;
    /**企业法人身份证*/
    private String businessPeopleCardId;
    /**来源 0:自荐,1:邀约*/
    private String source;
    /**是否纳税人 0:是,1:否*/
    private String isTaxpayer;
    /**经营方式*/
    private String manageMethod;
    /**公司介绍*/
    private String companyIntroduce;
    /**联系人类别 0:负责人,1:对接人,2:物流联系人,3:退货对接人*/
    private String contactType;
    /**联系人姓名*/
    private String contactName;
    /**联系人手机*/
    private String contactPhone;
    /**联系人微信*/
    private String contactWechat;
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
