package com.gugugou.provider.aptitude.controller;

import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: AptitudeController
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 15:59
 */
@RequestMapping("brand/aptitude")
@RestController
public class BrandController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BrandService brandService;

    public Long addBrand(BrandModel brandModel) {
        logger.info("新增品牌资质的入参--brandModel：{}",brandModel);
        return brandService.addBrand(brandModel);
    }
}
