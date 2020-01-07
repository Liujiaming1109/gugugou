package com.gugugou.provider.aptitude.dto.request;

import com.gugugou.provider.common.RequestDTO;
import lombok.Data;

/**
 * @author: chengShaoShao
 * @Title: BrandSkuPathRequestDTO
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/6 13:16
 */
@Data
public class BrandSkuPathRequestDTO extends RequestDTO {

    private static final long serialVersionUID = -3601384631776503066L;
    /** 品牌id */
    private Long brandId ;
    /** 类目id */
    private Long typeId ;
    /** skuId */
    private Long skuId ;
    /** 供应商外键id */
    private Long providerIdFk ;
    /** 供应商名称 */
    private String providerName ;
}
