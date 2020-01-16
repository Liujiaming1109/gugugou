package com.gugugou.provider.aptitude.dao;

import com.gugugou.provider.aptitude.dto.response.SelectListDTO;
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
    Long addAptitude(BrandModel brandModel);

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
    List<BrandModel> selectAptitudeListByPage(BrandModel brandModel);

    /**
     * 查询品牌所有数据
     * @return
     */
    List<BrandModel> selectAptitudeList();

    /**
     * 分页数据条数
     *
     * @param brandModel
     * @return
     */
    Long selectAptitudeListCount(BrandModel brandModel);

    /**
     * 查询单条品牌资质数据详情
     *
     * @param id
     * @return
     */
    BrandModel getAptitudeById(Long id);

    /**
     * 根据品牌数据主键id查询附件
     *
     * @param id
     * @return
     */
    List<AccessoryUrlModel> getAccessoryByBrandIdFk(Long id);

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

    /**
     * 查询品牌在该类目下的其他供应商（扣点降序）
     * @param brandModel
     * @return
     */
    List<BrandModel> selectProviderBucklePointList(BrandModel brandModel);

    /**
     * 修改扣点
     * @param brandModel
     * @return
     */
    int updateBucklePoint(BrandModel brandModel);

    /**
     * 查询资质到期时间和采购负责人邮箱
     * @return
     */
    List<SelectListDTO> selectList();

    /**
     * 根据品牌和类目查询供应商列表分页
     * @param brandModel
     * @return
     */
    List<BrandModel> selectProviderListByBrandId(BrandModel brandModel);

    /**
     * 根据品牌查询供应商数据
     */
    List<BrandModel> selectProviderByBrandId(Long id);

    /**
     * 根据品牌和类目查询供应商列表数量
     * @param brandModel
     * @return
     */
    Long selectProviderCountByBrandIdAndTypeId(BrandModel brandModel);
}
