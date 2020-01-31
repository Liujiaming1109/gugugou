package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.IconModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: IconDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/31 13:34
 */
@Mapper
public interface IconDao {

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
    List<IconModel> selectIconListByPage(IconModel iconModel);

    /**
     * 分页数据条数
     * @param iconModel
     * @return
     */
    Long selectIconListCount(IconModel iconModel);

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    IconModel  getIconById(Long id);

    /**
     * 根据id删除图片
     * @param iconModel
     * @return
     */
    int deleteById(IconModel iconModel);

    /**
     * 编辑图片
     */
    int updateIcon(IconModel iconModel);
}
