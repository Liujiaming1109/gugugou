package com.gugugou.provider.aptitude.dao;

import com.gugugou.provider.aptitude.model.BrandModel;

/**
 * @author: chengShaoShao
 * @Title: AptitudeDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 14:51
 */
public interface BrandDao {

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    Long addBrand(BrandModel brandModel);


}
