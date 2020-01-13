package com.gugugou.provider.stream.service;



import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;

import com.gugugou.provider.commodity.model.SkuPathModel;
import com.gugugou.provider.common.ResponseDTO;


public interface StreamingSkuPathService {

    /**设置排班间商品sku的扣点*/
    int updateStreamingSkuPath(SkuPathModel skuPathModel);

    /**批量修改排班表供应商的*/
    Integer updateStreamingkuPointList(UpdateSkuPathListRequest updateSkuPathListRequest);

    /**查找路径下的扣点列表*/
    ResponseDTO findStreamingSkuPoints(SkuPathModel skuPathModel);


}
