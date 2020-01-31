package com.gugugou.provider.commodity.service;

import com.gugugou.provider.commodity.model.PicModel;
import com.gugugou.provider.common.ResponseDTO;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: PicService
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/26 12:14
 */
public interface PicService {

    /**
     * 新增图片
     * @param picModel
     * @return
     */
    Long insertPic(PicModel picModel);

    /**
     * 批量新增图片
     * @param picModels
     * @return
     */
    List<Long> insertPicList(List<PicModel> picModels);

    /**
     * 分页查询图片列表
     * @param picModel
     * @return
     */
    ResponseDTO selectPicListByPage(PicModel picModel);

    /**
     * 分页查询已发布图片列表
     * @param picModel
     * @return
     */
    ResponseDTO selectPicReleaseListByPage(PicModel picModel);

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    PicModel  getPicById(Long id);

    /**
     * 根据id删除图片
     * @param picModel
     * @return
     */
    Integer deleteById(PicModel picModel);

    /**
     * 编辑图片
     */
    Integer updatePic(PicModel picModel);

    /**
     * 修改发布状态
     * @param picModel
     * @return
     */
    Integer updatedPicStatus(PicModel picModel);
}
