package com.gugugou.provider.commodity.service;


import com.gugugou.provider.commodity.dto.request.AddCommodityRequest;

/**
 * @author: chengShaoShao
 * @Title: ItemPathService
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 10:44
 */
public interface ItemPathService {

    /**
     * 路径添加商品
     */
    Long addPathCommodity(AddCommodityRequest addCommodityRequest);
}
