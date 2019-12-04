package com.gugugou.provider.aptitude.service;

import com.gugugou.provider.aptitude.dto.BrandResponseDTO;
import com.gugugou.provider.aptitude.dto.ResponseDTO;
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
    Integer addAptitude(BrandModel brandModel);

    /**
     * 带条件分页查询
     * @param brandModel
     * @return
     */
    ResponseDTO selectAptitudeList(BrandModel brandModel);

    /**
     * 查询单条品牌资质数据详情
     * @param id
     * @return
     */
    BrandResponseDTO getAptitudeById(Integer id);

}
