package com.gugugou.provider.commodity.controller;

import com.gugugou.provider.commodity.DTO.RequestDTO;
import com.gugugou.provider.commodity.model.PathModel;
import com.gugugou.provider.commodity.service.PathService;
import com.gugugou.provider.common.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: PathController
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/11 17:03
 */
@RequestMapping("commodity/path")
@RestController
public class PathController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PathService pathService;

    /**
     * 添加路径
     * @param pathModel
     * @return
     */
    @PostMapping("addPath")
    public Long addPath(@RequestBody PathModel pathModel) {
        logger.info("添加路径的入参--pathModel：{}", pathModel);
        return pathService.addPath(pathModel);
    }

    /**
     * 分页查询路径列表
     * @param requestDTO
     * @return
     */
    @PostMapping("selectPathListByPage")
    public ResponseDTO selectPathListByPage(@RequestBody RequestDTO requestDTO) {
        logger.info("分页查询路径列表--requestDTO：{}", requestDTO);
        return pathService.selectPathListByPage(requestDTO);
    }

    /**
     * 查询单条路径数据详情
     * @param id
     * @return
     */
    @GetMapping("getPathById")
    public PathModel getPathById(@RequestParam Long id) {
        logger.info("查询单条路径数据详情的入参--id：{}", id);
        return pathService.getPathById(id);
    }

    /**
     * 编辑路径
     * @param pathModel
     * @return
     */
    @PostMapping("updatePath")
    public Integer updatePath(@RequestBody PathModel pathModel) {
        logger.info("编辑路径的入参--pathModel：{}", pathModel);
        return pathService.updatePath(pathModel);
    }

    /**
     * 关闭路径
     * @param pathModel
     * @return
     */
    @PostMapping("closePath")
    public Integer closePath(@RequestBody PathModel pathModel) {
        logger.info("关闭路径的入参--pathModel：{}", pathModel);
        return pathService.closePath(pathModel);
    }

    /**
     * 开启路径
     * @param pathModel
     * @return
     */
    @PostMapping("openPath")
    public Integer openPath(@RequestBody PathModel pathModel) {
        logger.info("开启路径的入参--pathModel：{}", pathModel);
        return pathService.openPath(pathModel);
    }
}
