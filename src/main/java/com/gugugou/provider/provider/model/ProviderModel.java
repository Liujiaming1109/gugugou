package com.gugugou.provider.provider.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: providerModel
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 13:30
 */
public class ProviderModel {

    /** 主键id */
    private Integer id ;
    /** 品牌id */
    private Integer brandId ;
    /** 品牌名称 */
    private String brandName ;
    /** 类目 */
    private String type ;
    /** 供应商id */
    private Integer providerId ;
    /** 供应商名称 */
    private String providerName ;
    /** 经营状态 */
    private String manageStatus ;
    /** 经营方式 */
    private Integer manageMethod ;
    /** 扣点 */
    private String bucklePoint ;
    /** 派单权重 */
    private String sendOrderWeight ;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus;
    }

    public Integer getManageMethod() {
        return manageMethod;
    }

    public void setManageMethod(Integer manageMethod) {
        this.manageMethod = manageMethod;
    }

    public String getBucklePoint() {
        return bucklePoint;
    }

    public void setBucklePoint(String bucklePoint) {
        this.bucklePoint = bucklePoint;
    }

    public String getSendOrderWeight() {
        return sendOrderWeight;
    }

    public void setSendOrderWeight(String sendOrderWeight) {
        this.sendOrderWeight = sendOrderWeight;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getRemoved() {
        return removed;
    }

    public void setRemoved(Integer removed) {
        this.removed = removed;
    }
}
