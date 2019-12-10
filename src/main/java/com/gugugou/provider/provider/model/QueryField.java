package com.gugugou.provider.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class QueryField implements Serializable {

    private Integer pageIndex;

    private Integer pageSize;

    /**供应商id*/
    @JsonProperty("provider_id_fk")
    private int providerIdFk;
    /**供应商名称*/
    private String companyName;
    /**公司邮件*/
    @JsonProperty("company_email")
    private String companyEmail;
    /**经营状态*/
    private String manageStatus;
    /**经营方式*/
    private String manageMethod;
    /**结算周期*/
    private String settlementInterval;
    /**供应商授权等级*/
    private String providerAuthLevel;
    /**品牌名称*/
    @JsonProperty("brand_name")
    private String brandName;
    /**类目名称*/
    @JsonProperty("type_name ")
    private String typeName;
    /**合同状态*/
    @JsonProperty("contract_status")
    private String contractStatus;
    /**合同到期日期*/
    @JsonProperty("contact_end_date")
    private Date contactEndDate;
    /**是否续约*/
    private String isContactExtension;
    /**平台负责人*/
    @JsonProperty("platform_principal")
    private String platformPrincipal;
}
