package com.gugugou.provider.commodity.service;

import com.gugugou.provider.commodity.model.PathPriceModel;

/**
 * @author: chengShaoShao
 * @Title: PathPriceService
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 19:45
 */
public interface PathPriceService {

    /**
     * 设置路径售价
     * @param pathPriceModel
     * @return
     */
    Integer updatePathPrice(PathPriceModel pathPriceModel);
}
