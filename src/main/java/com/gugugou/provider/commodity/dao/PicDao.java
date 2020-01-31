package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.PicModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: PicDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/21 16:45
 */
@Mapper
public interface PicDao {

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
    List<PicModel> selectPicListByPage(PicModel picModel);

    /**
     * 分页数据条数
     * @param picModel
     * @return
     */
    Long selectPicListCount(PicModel picModel);

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
    int deleteById(PicModel picModel);

    /**
     * 编辑图片
     */
    int updatePic(PicModel picModel);
}
