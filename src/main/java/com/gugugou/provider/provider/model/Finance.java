package com.gugugou.provider.provider.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Finance implements Serializable {

    private static final long serialVersionUID = -2319434748464563724L;
    /*主键id*/
    private Integer id;
    /*供应商外键id*/
    private Integer providerIdFk;
    /*开户银行*/
    private String openBank;
    /*开户账号*/
    private String bankNumber;
    /*开户行支行名称*/
    private String branchBankName;
    /*开户名*/
    private String accountName;
    /*开户行地址*/
    private String bankAddress;
    /*公司注册地址*/
    private String registeredAddress;
    /*开户行详细地址*/
    private String bankDetailAddress;
    /*注册地电话*/
    private String registeredPhone;
    /*发票抬头*/
    private String invoiceTitle;
    /*发票收件人*/
    private String invoiceRecipients;
    /*发票收件人手机*/
    private String invoiceRecipientsPhone;
    /*发票收件地址*/
    private String invoiceRecipientsAddress;
    /*税务代码*/
    private String taxCode;
    /*纳税人识别号*/
    private String taxIdentificationNumber;
    /*支付宝账户名称*/
    private String alipayAccountName;
    /*支付宝账号*/
    private String alipayNumber;
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
