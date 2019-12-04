package com.gugugou.provider.aptitude.controller;

import com.gugugou.provider.aptitude.dto.BrandResponseDTO;
import com.gugugou.provider.aptitude.dto.ResponseDTO;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询单条品牌资质数据明细
     * @param id
     * @return
     */
    @GetMapping("getAptitudeById")
    public BrandResponseDTO getAptitudeById(Integer id) {
        logger.info("查询单条品牌资质数据明细的入参--id：{}", id);
        return brandService.getAptitudeById(id);
    }
}
