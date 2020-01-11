package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.SkuModel;
import com.gugugou.provider.commodity.model.SkuPathModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: SkuDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 20:48
 */
public interface SkuDao {

    /**
     * 带条件搜索sku
     * @param skuModel
     * @return
     */
    List<SkuModel> searchSku(SkuModel skuModel);

    /**
     *
     * @param id
     * @return
     */
    SkuModel searchSku(@Param("id") Long id);
}
