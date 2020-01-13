package com.gugugou.provider.aptitude.service;

import com.gugugou.provider.aptitude.dto.request.BrandSkuPathRequestDTO;
import com.gugugou.provider.aptitude.dto.response.BrandResponseDTO;
import com.gugugou.provider.aptitude.dto.response.BrandSkuPathResponseDTO;
import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.common.ResponseDTO;

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
    Long addAptitude(BrandModel brandModel);

    /**
     * 带条件分页查询
     * @param brandModel
     * @return
     */
    ResponseDTO selectAptitudeListByPage(BrandModel brandModel);

    /**
     * 查询单条品牌资质数据详情
     * @param id
     * @return
     */
    BrandResponseDTO getAptitudeById(Long id);

    /**
     * 编辑品牌资质
     * @param brandModel
     * @return
     */
    Integer updateAptitude(BrandModel brandModel);

    /**
     * 删除品牌资质附件
     * @param accessoryUrlModel
     * @return
     */
    Integer deleteAccessory(AccessoryUrlModel accessoryUrlModel);

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
    Integer updateProvider(BrandModel brandModel);

    /**
     * 关闭派单权重
     * @param brandModel
     * @return
     */
    Integer closeProvider(BrandModel brandModel);

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
    Integer updateBucklePoint(BrandModel brandModel);

}
