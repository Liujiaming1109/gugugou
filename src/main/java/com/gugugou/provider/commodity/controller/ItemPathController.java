package com.gugugou.provider.commodity.controller;

import com.gugugou.provider.commodity.dto.request.AddCommodityRequest;
import com.gugugou.provider.commodity.service.ItemPathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: ItemPathController
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 19:56
 */
@RequestMapping("commodity/itemPath")
@RestController
public class ItemPathController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ItemPathService itemPathService;

    /**
     * 添加商品
     * @param addCommodityRequest
     * @return
     */
    @PostMapping("addPathCommodity")
    public Long addPathCommodity(@RequestBody AddCommodityRequest addCommodityRequest) {
        logger.info("添加商品的入参--addCommodityRequest：{}", addCommodityRequest);
        return itemPathService.addPathCommodity(addCommodityRequest);
    }
}
