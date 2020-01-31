package com.gugugou.provider.commodity.controller;

import com.gugugou.provider.commodity.model.PicModel;
import com.gugugou.provider.commodity.service.PicService;
import com.gugugou.provider.common.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: PicController
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/31 12:38
 */
@RequestMapping("commodity/pic")
@RestController
public class PicController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PicService picService;

    /**
     * 新增图片
     * @param picModel
     * @return
     */
    @PostMapping("insertPic")
    public Long insertPic(@RequestBody PicModel picModel) {
        logger.info("新增图片的入参--picModel：{}", picModel);
        return picService.insertPic(picModel);
    }

    /**
     * 批量新增图片
     * @param picModels
     * @return
     */
    @PostMapping("insertPicList")
    public List<Long> insertPicList(@RequestBody List<PicModel> picModels) {
        logger.info("批量新增图片的入参--picModels：{}", picModels);
        return picService.insertPicList(picModels);
    }

    /**
     * 分页条件查询图片列表
     * @param picModel
     * @return
     */
    @PostMapping("selectPicListByPage")
    public ResponseDTO selectPicListByPage(@RequestBody PicModel picModel) {
        logger.info("分页条件查询图片列表的入参--picModel：{}", picModel);
        return picService.selectPicListByPage(picModel);
    }

    /**
     * 分页查询已发布图片列表
     * @param picModel
     * @return
     */
    @PostMapping("selectPicReleaseListByPage")
    public ResponseDTO selectPicReleaseListByPage(@RequestBody PicModel picModel) {
        logger.info("分页查询已发布图片列表--picModel：{}", picModel);
        return picService.selectPicReleaseListByPage(picModel);
    }

    /**
     * 根据id查看数据详情
     * @param id
     * @return
     */
    @GetMapping("getPicById")
    public PicModel getPicById(@RequestParam("id") Long id) {
        logger.info("根据id查看数据详情的入参--id：{}", id);
        return picService.getPicById(id);
    }

    /**
     * 根据id删除数据
     * @param picModel
     * @return
     */
    @PostMapping("deleteById")
    public Integer deleteById(@RequestBody PicModel picModel) {
        logger.info("根据id删除数据的入参--picModel：{}", picModel);
        return picService.deleteById(picModel);
    }

    /**
     * 编辑图片信息
     * @param picModel
     * @return
     */
    @PostMapping("updatePic")
    public Integer updatePic(@RequestBody PicModel picModel) {
        logger.info("编辑图片信息的入参--picModel：{}", picModel);
        return picService.updatePic(picModel);
    }

    /**
     * 修改发布状态
     * @param picModel
     * @return
     */
    @PostMapping("updatedPicStatus")
    public Integer updatedPicStatus(@RequestBody PicModel picModel) {
        logger.info("修改发布状态的入参--picModel：{}", picModel);
        return picService.updatedPicStatus(picModel);
    }
}
