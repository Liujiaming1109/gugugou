package com.gugugou.provider.commodity.service;

import com.gugugou.provider.commodity.model.IconModel;
import com.gugugou.provider.common.ResponseDTO;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: IconService
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/31 16:01
 */
public interface IconService {

    /**
     * 新增图片
     * @param iconModel
     * @return
     */
    Long insertIcon(IconModel iconModel);

    /**
     * 批量新增图片
     * @param iconModels
     * @return
     */
    List<Long> insertIconList(List<IconModel> iconModels);

    /**
     * 分页查询图片列表
     * @param iconModel
     * @return
     */
    ResponseDTO selectIconListByPage(IconModel iconModel);

    /**
     * 分页查询已发布图片列表
     * @param iconModel
     * @return
     */
    ResponseDTO selectIconReleaseListByPage(IconModel iconModel);

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    IconModel getIconById(Long id);

    /**
     * 根据id删除图片
     * @param iconModel
     * @return
     */
    Integer deleteById(IconModel iconModel);

    /**
     * 编辑图片/修改发布状态
     */
    Integer updateIcon(IconModel iconModel);

}
