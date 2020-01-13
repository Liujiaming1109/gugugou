package com.gugugou.provider.commodity.dto.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: UpdateSkuPathModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/7 11:52
 */
@Data
public class UpdateSkuPathModel implements Serializable {


    private static final long serialVersionUID = -6399251308573684369L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 供应商外键
     */
    private Long providerId;

    /**
     * skuId
     */
    private Long skuId;

}
