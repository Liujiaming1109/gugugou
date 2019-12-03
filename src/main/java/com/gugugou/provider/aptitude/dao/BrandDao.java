package com.gugugou.provider.aptitude.dao;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: AptitudeDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 14:51
 */
@Mapper
public interface BrandDao {

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    Long addBrand(BrandModel brandModel);

    /**
     * 批量新增附件路径
     * @param accessoryUrlModels
     * @return
     */
    Integer addAccessoryList(List<AccessoryUrlModel> accessoryUrlModels);

}
