package com.gugugou.provider.aptitude.service;

import com.gugugou.provider.aptitude.DTO.ResponseDTO;
import com.gugugou.provider.aptitude.model.BrandModel;

import java.util.List;

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
    Integer addAptitude(BrandModel brandModel);

    /**
     * 带条件分页查询
     * @param brandModel
     * @return
     */
    ResponseDTO selectAptitudeList(BrandModel brandModel);
}
