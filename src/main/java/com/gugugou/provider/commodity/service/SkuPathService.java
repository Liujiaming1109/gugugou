package com.gugugou.provider.commodity.service;


import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;
import com.gugugou.provider.commodity.model.SkuPathModel;


/**
 * @author: chengShaoShao
 * @Title: SkuPointService
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/27 15:36
 */
public interface SkuPathService {

    /**
     * 修改扣点
     * @param skuPathModel
     * @return
     */
    Integer updateSkuPoint(SkuPathModel skuPathModel);

    /**
     * 批量修改扣点
     * @param updateSkuPathListRequest
     * @return
     */
    Integer updateSkuPointList(UpdateSkuPathListRequest updateSkuPathListRequest);
}
