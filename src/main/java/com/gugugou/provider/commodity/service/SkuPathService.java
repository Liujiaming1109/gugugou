package com.gugugou.provider.commodity.service;


import com.gugugou.provider.commodity.dto.request.UpdatePathPointListRequest;
import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;
import com.gugugou.provider.commodity.model.SkuPathModel;
import com.gugugou.provider.common.ResponseDTO;

import java.util.List;


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

    /**
     * 查询路径下的扣点列表
     * @param skuPathModel
     * @return
     */
    ResponseDTO selectPathPointListByPage(SkuPathModel skuPathModel);

    /**
     * 修改路径扣点
     * @param skuPathModel
     * @return
     */
    Integer updatePathPoint(SkuPathModel skuPathModel);

    /**
     * 批量修改路径扣点
     * @return
     */
    Integer updatePathPointList(UpdatePathPointListRequest updatePathPointListRequest);


}
