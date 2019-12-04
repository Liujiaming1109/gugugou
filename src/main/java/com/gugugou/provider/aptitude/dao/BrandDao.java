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
    Integer addAptitude(BrandModel brandModel);

    /**
     * 批量新增附件路径
     * @param accessoryUrlModels
     * @return
     */
    Integer addAccessoryList(List<AccessoryUrlModel> accessoryUrlModels);

    /**
     * 带条件分页查询
     * @param brandModel
     * @return
     */
    List<BrandModel> selectAptitudeList(BrandModel brandModel);

    /**
     * 分页数据条数
     * @param brandModel
     * @return
     */
    Integer selectAptitudeListCount(BrandModel brandModel);

    /**
     * 查询单条品牌资质数据详情
     * @param id
     * @return
     */
    BrandModel getAptitudeById(Integer id);

    /**
     * 根据品牌数据主键id查询附件
     * @param id
     * @return
     */
    List<AccessoryUrlModel> getAccessoryByBrandIdFk(Integer id);


}
