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
     *
     * @param brandModel
     * @return
     */
    int addAptitude(BrandModel brandModel);

    /**
     * 批量新增附件路径
     *
     * @param accessoryUrlModels
     * @return
     */
    int addAccessoryList(List<AccessoryUrlModel> accessoryUrlModels);

    /**
     * 带条件分页查询
     *
     * @param brandModel
     * @return
     */
    List<BrandModel> selectAptitudeList(BrandModel brandModel);

    /**
     * 分页数据条数
     *
     * @param brandModel
     * @return
     */
    int selectAptitudeListCount(BrandModel brandModel);

    /**
     * 查询单条品牌资质数据详情
     *
     * @param id
     * @return
     */
    BrandModel getAptitudeById(Integer id);

    /**
     * 根据品牌数据主键id查询附件
     *
     * @param id
     * @return
     */
    List<AccessoryUrlModel> getAccessoryByBrandIdFk(Integer id);

    /**
     * 编辑品牌资质
     *
     * @param brandModel
     * @return
     */
    int updateAptitude(BrandModel brandModel);

    /**
     * 编辑品牌资质附件
     *
     * @param accessoryUrlModel
     * @return
     */
    int updateAccessory(AccessoryUrlModel accessoryUrlModel);

    /**
     * 删除品牌资质附件
     * @param accessoryUrlModel
     * @return
     */
    int deleteAccessory(AccessoryUrlModel accessoryUrlModel);

    /**
     * 查询品牌在该类目下的其他供应商(新增品牌资质用)
     * @param brandModel
     * @return
     */
    List<BrandModel> selectProviderPriorityList(BrandModel brandModel);

    /**
     * 查询品牌在该类目下的其他供应商（修改优先级用）
     * @param brandModel
     * @return
     */
    List<BrandModel> selectProviderPriorityListOne(BrandModel brandModel);

    /**
     * 修改派单优先级
     * @param brandModel
     * @return
     */
    int updateProvider(BrandModel brandModel);
}
