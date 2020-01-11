package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.PathPriceModel;

/**
 * @author: chengShaoShao
 * @Title: PathPriceDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 10:36
 */
public interface PathPriceDao {
    /**
     * 新增路径价格表
     * @param pathPriceModel
     * @return
     */
    Long insertPathPrice(PathPriceModel pathPriceModel);

    /**
     * 设置路径售价
     * @param pathPriceModel
     * @return
     */
    int updatePathPrice(PathPriceModel pathPriceModel);
}
