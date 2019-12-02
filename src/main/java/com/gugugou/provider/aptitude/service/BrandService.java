package com.gugugou.provider.aptitude.service;

import com.gugugou.provider.aptitude.model.BrandModel;

/**
 * @author: chengShaoShao
 * @Title: BrandService
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 15:35
 */
public interface BrandService {

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    Integer addBrand(BrandModel brandModel);

}
