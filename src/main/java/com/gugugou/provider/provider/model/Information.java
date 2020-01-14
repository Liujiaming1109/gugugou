package com.gugugou.provider.provider.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Information implements Serializable {

    /**主键*/
    private Long id;

    /** 当前页面 */
    private Integer pageIndex;

    /** 每页数据 */
    private Integer pageSize;

    /**结算周期*/
    private int settlementInterval;

    /**公司名称*/
    private String providerName;

    /**公司邮件*/
    private String companyEmail;

    /**合同id*/
    private String contactId;

    /**合同开始时间*/
    private String contactStartDate;

    /**合同结束时间*/
    private String contactEndDate;

    /**合同状态*/
    private int  contractStatus;

    /**是否续约 0:续约,1:不续约*/
    private int isContactExtension;

    /**公司地址*/
    private String companyAddress;

    /**营业执照号*/
    private String permitNumber;

    /**企业法人*/
    private String businessPeople;

    /**企业法人身份证*/
    private String businessPeopleCardId;

    /**来源 0:自荐,1:邀约*/
    private int source;

    /**是否纳税人 0:是,1:否*/
    private int isTaxpayer;

    /**经营方式*/
    private String manageMethod;

    /**公司的经营状态*/
    private Integer manageStatus;

    /**改变经营状态的原因*/
    private String changeReason;

    /**公司介绍*/
    private String companyIntroduce;

    /**平台负责人*/
    private String platformPrincipal;

    /**平台负责人邮件*/
    private String principalEmail;

    /**上一次结算时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastSettlementTime;

    /**下一次结算时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nextSettlementTime;

    /**创建人*/
    private String createdBy;

    /**创建时间*/
    private Date createdTime;

    /**更新人*/
    private String updatedBy;

    /**更新时间*/
    private Date updatedTime;

    /**逻辑删除*/
    private int removed;

    /**联系人的sku表*/
    private List<InformationContact> informationContacts;

}
