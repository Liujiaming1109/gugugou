package com.gugugou.provider.aptitude.dto.response;

import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.commodity.dto.response.SkuPathResponseDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: BrandSkuPathResponseDTO
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/6 13:24
 */
public class BrandSkuPathResponseDTO implements Serializable {

    private static final long serialVersionUID = 3372041924541556303L;
    /**
     * 扣点集合
     */
    private List<SkuPathResponseDTO> skuPathModelList;

    /**
     * 品牌资质集合
     */
    private List<BrandModel> brandModelList;

    /**
     * 数据条数
     */
    private Long count;


    public List<BrandModel> getBrandModelList() {
        return brandModelList;
    }

    public void setBrandModelList(List<BrandModel> brandModelList) {
        this.brandModelList = brandModelList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<SkuPathResponseDTO> getSkuPathModelList() {
        return skuPathModelList;
    }

    public void setSkuPathModelList(List<SkuPathResponseDTO> skuPathModelList) {
        this.skuPathModelList = skuPathModelList;
    }
}
