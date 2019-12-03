package com.gugugou.provider.aptitude.controller;

import com.gugugou.provider.aptitude.DTO.ResponseDTO;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    @PostMapping("addAptitude")
    public Integer addAptitude(@RequestBody BrandModel brandModel) {
        logger.info("新增品牌资质的入参--brandModel：{}",brandModel);
        return brandService.addAptitude(brandModel);
    }

    /**
     * 带条件查询品牌列表
     * @param brandModel
     * @return
     */
    @PostMapping("selectAptitudeList")
    public ResponseDTO selectAptitudeList(@RequestBody BrandModel brandModel) {
        logger.info("查询品牌列表的入参--brandModel：{}", brandModel);
        return brandService.selectAptitudeList(brandModel);
    }
}
