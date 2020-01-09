package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.dto.response.SkuPathResponseDTO;
import com.gugugou.provider.commodity.model.SkuPathModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * 根据skuId判断是否有商品原有扣点数据
     * @param id
     * @return
     */
    SkuPathModel getSkuPathBySkuId(Long id);

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

    /**
     * 查询路径下的扣点列表
     * @param skuPathModel
     * @return
     */
    List<SkuPathModel> selectPathPointListByPage(SkuPathModel skuPathModel);

    /**
     * 查询路径下的扣点数据数量
     * @param skuPathModel
     * @return
     */
    Long selectPathPointCountByPage(SkuPathModel skuPathModel);

    /**
     * 修改路径扣点
     * @param skuPathModel
     * @return
     */
    int updatePathPoint(SkuPathModel skuPathModel);

    /**
     * selectSkuIdByPathIdAndItemId
     * @param itemId
     * @param pathId
     * @return
     */
    List<SkuPathModel> selectSkuIdByPathIdAndItemId(@Param("itemId") Long itemId, @Param("pathId") Long pathId);


}
