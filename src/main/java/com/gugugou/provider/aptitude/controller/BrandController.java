package com.gugugou.provider.aptitude.controller;

import com.gugugou.provider.aptitude.dto.request.BrandSkuPathRequestDTO;
import com.gugugou.provider.aptitude.dto.response.BrandResponseDTO;
import com.gugugou.provider.aptitude.dto.response.BrandSkuPathResponseDTO;
import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.common.until.SendEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private SendEmail sendEmail;

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    @PostMapping("addAptitude")
    public Long addAptitude(@RequestBody BrandModel brandModel) {
        logger.info("新增品牌资质的入参--brandModel：{}",brandModel);
        return brandService.addAptitude(brandModel);
    }

    /**
     * 带条件查询品牌列表
     * @param brandModel
     * @return
     */
    @PostMapping("selectAptitudeList")
    public ResponseDTO selectAptitudeListByPage(@RequestBody BrandModel brandModel) {
        logger.info("查询品牌列表的入参--brandModel：{}", brandModel);
        return brandService.selectAptitudeListByPage(brandModel);
    }

    /**
     * 查询单条品牌资质数据明细
     * @param id
     * @return
     */
    @GetMapping("getAptitudeById")
    public BrandResponseDTO getAptitudeById(@RequestParam Long id) {
        logger.info("查询单条品牌资质数据明细的入参--id：{}", id);
        return brandService.getAptitudeById(id);
    }

    /**
     * 编辑品牌资质
     * @param brandModel
     * @return
     */
    @PostMapping("updateAptitude")
    public Integer updateAptitude(@RequestBody BrandModel brandModel) {
        logger.info("编辑品牌资质信息的入参--brandModel：{}",brandModel);
        return brandService.updateAptitude(brandModel);
    }

    /**
     * 删除品牌资质的附件
     * @param accessoryUrlModel
     * @return
     */
    @PostMapping("deleteAccessory")
    public Integer deleteAccessory(@RequestBody AccessoryUrlModel accessoryUrlModel) {
        logger.info("删除品牌资质附件的入参--accessoryUrlModel：{}", accessoryUrlModel);
        return brandService.deleteAccessory(accessoryUrlModel);
    }

    /**
     * 查询品牌在该类目下的其他供应商
     * @param brandModel
     * @return
     */
    @PostMapping("selectProviderPriorityListOne")
    public List<BrandModel> selectProviderPriorityListOne(@RequestBody BrandModel brandModel) {
        logger.info("查询品牌在该类目下的其他供应商入参优先级--brandModel：{}", brandModel);
        return brandService.selectProviderPriorityListOne(brandModel);
    }

    /**
     * 查询品牌在该类目下的其他供应商（扣点降序）
     * @param brandModel
     * @return
     */
    @PostMapping("selectProviderBucklePointList")
    public List<BrandModel> selectProviderBucklePointList(@RequestBody BrandModel brandModel) {
        logger.info("查询品牌在该类目下的其他供应商扣点--brandModel：{}", brandModel);
        return brandService.selectProviderBucklePointList(brandModel);
    }

    /**
     * 关闭派单权重
     * @param brandModel
     * @return
     */
    @PostMapping("closeProvider")
    public Integer closeProvider(@RequestBody BrandModel brandModel) {
        logger.info("关闭派单权重的入参--brandModel：{}", brandModel);
        return brandService.closeProvider(brandModel);
    }

    /**
     * 修改派单优先级
     * @param brandModel
     * @return
     */
    @PostMapping("updateProvider")
    public Integer updateProvider(@RequestBody BrandModel brandModel) {
        logger.info("修改派单优先级的入参--brandModel：{}", brandModel);
        return brandService.updateProvider(brandModel);
    }

    /**
     * 修改扣点
     * @param brandModel
     * @return
     */
    @PostMapping("updateBucklePoint")
    public Integer updateBucklePoint(@RequestBody BrandModel brandModel) {
        logger.info("修改扣点的入参--brandModel：{}", brandModel);
        return brandService.updateBucklePoint(brandModel);
    }

    /**
     * 根据品牌和类目查询供应商列表
     * @param brandSkuPathRequestDTO
     * @return
     */
    @PostMapping("selectProviderListByBrandIdAndTypeId")
    public BrandSkuPathResponseDTO selectProviderListByBrandIdAndTypeId(@RequestBody BrandSkuPathRequestDTO brandSkuPathRequestDTO) {
        logger.info("根据品牌和类目查询供应商列表--brandModel：{}", brandSkuPathRequestDTO);
        return brandService.selectProviderListByBrandIdAndTypeId(brandSkuPathRequestDTO);
    }
}
