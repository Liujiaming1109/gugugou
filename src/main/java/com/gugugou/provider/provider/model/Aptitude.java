package com.gugugou.provider.provider.model;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Aptitude implements Serializable {


    /** 主键id*/
    private int id;
    /** 供应商外键id*/
    private int providerIdFk;
    /** 资质状态*/
    private int aptitudeStatus;
    /** 营业执照生效日期*/
    private Date businessStartDate;
    /** 营业执照到期日期*/
    private Date businessEndDate;
    /** 组织机构生效日期*/
    private Date organizationStartDate;
    /** 组织机构到期日期*/
    private Date organizationEndDate;
    /** 纳税人资格证明生效时间*/
    private Date taxpayerStartDate;
    /** 纳税人资格证明到期时间*/
    private Date taxpayerEndDate;
    /** 银行开户许可证生效日期*/
    private Date bankStartDate;
    /** 银行开户许可证到期日期*/
    private Date bankEndDate;
    /** 法定代表人生效日期*/
    private Date representativeStartDate;
    /** 法定代表人到期日期*/
    private Date representativeEndDate;
    /** 创建人*/
    private int createdBy;
    /** 创建时间*/
    private Date createdTime;
    /** 更新人*/
    private int updatedBy;
    /** 更新时间*/
    private Date updatedTime;
    /** 逻辑删除*/
    private int removed;

    /**税务登记附件*/
    private List<AccessoryUrlModel> taxRegistration;
    /**组织机构附件*/
    private List<AccessoryUrlModel> businessAccessory;
    /**一般纳税人资格说明附件*/
    private List<AccessoryUrlModel> taxPayerAccessory;
    /**银行开户附件*/
    private List<AccessoryUrlModel> bankAccessory;
    /**法定代表人身份附件*/
    private List<AccessoryUrlModel> representativeAccessory;








}
