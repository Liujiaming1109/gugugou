package com.gugugou.provider.commodity.controller;

import com.gugugou.provider.commodity.model.IconModel;
import com.gugugou.provider.commodity.service.IconService;
import com.gugugou.provider.common.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: IconController
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/31 16:16
 */
@RequestMapping("commodity/icon")
@RestController
public class IconController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private IconService iconService;

    /**
     * 新增图片
     * @param iconModel
     * @return
     */
    @PostMapping("insertIcon")
    public Long insertIcon(@RequestBody IconModel iconModel) {
        logger.info("新增图片的入参--iconModel：{}", iconModel);
        return iconService.insertIcon(iconModel);
    }

    /**
     * 批量新增图片
     * @param iconModels
     * @return
     */
    @PostMapping("insertIconList")
    public List<Long> insertIconList(@RequestBody List<IconModel> iconModels) {
        logger.info("批量新增图片的入参--iconModels：{}", iconModels);
        return iconService.insertIconList(iconModels);
    }

    /**
     * 分页条件查询图片列表
     * @param iconModel
     * @return
     */
    @PostMapping("selectIconListByPage")
    public ResponseDTO selectIconListByPage(@RequestBody IconModel iconModel) {
        logger.info("分页条件查询图片列表的入参--iconModel：{}", iconModel);
        return iconService.selectIconListByPage(iconModel);
    }

    /**
     * 分页查询已发布图片列表
     * @param iconModel
     * @return
     */
    @PostMapping("selectIconReleaseListByPage")
    public ResponseDTO selectIconReleaseListByPage(@RequestBody IconModel iconModel) {
        logger.info("分页查询已发布图片列表--iconModel：{}", iconModel);
        return iconService.selectIconReleaseListByPage(iconModel);
    }

    /**
     * 根据id查看数据详情
     * @param id
     * @return
     */
    @GetMapping("getIconById")
    public IconModel getIconById(@RequestParam("id") Long id) {
        logger.info("根据id查看数据详情的入参--id：{}", id);
        return iconService.getIconById(id);
    }

    /**
     * 根据id删除数据
     * @param iconModel
     * @return
     */
    @PostMapping("deleteById")
    public Integer deleteById(@RequestBody IconModel iconModel) {
        logger.info("根据id删除数据的入参--IconModel：{}", iconModel);
        return iconService.deleteById(iconModel);
    }

    /**
     * 编辑图片信息
     * @param iconModel
     * @return
     */
    @PostMapping("updateIcon")
    public Integer updateIcon(@RequestBody IconModel iconModel) {
        logger.info("编辑图片信息的入参--IconModel：{}", iconModel);
        return iconService.updateIcon(iconModel);
    }
}
