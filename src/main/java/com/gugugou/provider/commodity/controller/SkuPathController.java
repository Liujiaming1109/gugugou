package com.gugugou.provider.commodity.controller;

import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;
import com.gugugou.provider.commodity.model.SkuPathModel;
import com.gugugou.provider.commodity.service.SkuPathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: SkuPathController
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/6 17:27
 */
@RequestMapping("commodity/skuPath")
@RestController
public class SkuPathController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SkuPathService skuPathService;

    /**
     * 设置扣点
     * @param skuPathModel
     */
    @PostMapping("updateSkuPoint")
    public Integer updateSkuPoint(@RequestBody SkuPathModel skuPathModel) {
        logger.info("设置扣点的入参--skuPathModel：{}", skuPathModel);
        return skuPathService.updateSkuPoint(skuPathModel);
    }

    /**
     * 批量修改扣点
     * @param updateSkuPathListRequest
     * @return
     */
    @PostMapping("updateSkuPointList")
    public Integer updateSkuPointList(@RequestBody UpdateSkuPathListRequest updateSkuPathListRequest) {
        logger.info("批量修改扣点的入参--updateSkuPathListRequest：{}", updateSkuPathListRequest);
        return skuPathService.updateSkuPointList(updateSkuPathListRequest);
    }
}
