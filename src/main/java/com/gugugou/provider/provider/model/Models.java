package com.gugugou.provider.provider.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Models implements Serializable {

    private int id;

    private String tProviderFk;

    private String openBank;

    private String bankNumber;

    private String branchBankName;

    private String accountName;

    private String bankAddress;

    private String registeredAddress;

    private String bankDetailAddress;

    private String registeredPhone;

    private String invoiceTitle;

    private String invoiceRecipients;

    private String invoiceRecipientsPhone;

    private String invoiceRecipientsAddress;

    private String taxCode;

    private String taxIdentificationNumber;

    private String alipayAccountName;

    private String alipayNumber;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private int removed;
}
