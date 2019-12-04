package com.gugugou.provider.provider.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Aptitude implements Serializable {


    /** 主键id*/
    private int id;
    /** 供应商外键id*/
    private int provider_id_fk;
    /** 资质状态*/
    private int aptitude_status;
    /** 营业执照生效日期*/
    private int business_start_date;
    /** 营业执照到期日期*/
    private int business_end_date;
    /** 组织机构生效日期*/
    private int organization_start_date;
    /** 组织机构到期日期*/
    private int organization_end_date;
    /** 纳税人资格证明生效时间*/
    private int taxpayer_start_date;
    /** 纳税人资格证明到期时间*/
    private int taxpayer_end_date;
    /** 银行开户许可证生效日期*/
    private int bank_start_date;
    /** 银行开户许可证到期日期*/
    private int bank_end_date;
    /** 法定代表人生效日期*/
    private int representative_start_date;
    /** 法定代表人到期日期*/
    private int representative_end_date;
    /** 创建人*/
    private int created_by;
    /** 创建时间*/
    private int created_time;
    /** 更新人*/
    private int updated_by;
    /** 更新时间*/
    private int updated_time;
    /** 逻辑删除*/
    private int removed;







}
