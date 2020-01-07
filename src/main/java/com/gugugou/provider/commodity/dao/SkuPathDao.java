package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.dto.response.SkuPathResponseDTO;
import com.gugugou.provider.commodity.model.SkuPathModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: SkuInventoryDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/26 17:15
 */
@Mapper
public interface SkuPathDao {

    /**
     * 新增sku扣点表
     * @param skuPointModel
     * @return
     */
    Long insertSkuPath(SkuPathModel skuPointModel);

    /**
     * 根据供应商查询扣点
     * @param skuPointModel
     * @return
     */
    SkuPathResponseDTO selectSkuPathBySkuIdAndProviderId(SkuPathModel skuPointModel);

    /**
     * 根据id查询扣点表数据
     * @param id
     * @return
     */
    SkuPathModel getSkuPathById(Long id);

    /**
     * 查询所有修改扣点表数据
     * @return
     */
    List<SkuPathModel> selectSkuPointAll();

    /**
     * 修改扣点
     * @param skuPathModel
     * @return
     */
    int updateSkuPoint(SkuPathModel skuPathModel);
}
