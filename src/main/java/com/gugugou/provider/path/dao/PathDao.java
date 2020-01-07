package com.gugugou.provider.path.dao;

import com.gugugou.provider.common.RequestDTO;
import com.gugugou.provider.path.model.PathModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: PathDao
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/11 13:39
 */
@Mapper
public interface PathDao {

    /**
     * 添加路径
     * @param pathModel
     * @return
     */
    Long addPath(PathModel pathModel);

    /**
     * 分页查询路径列表
     * @param requestDTO
     * @return
     */
    List<PathModel> selectPathListByPage(RequestDTO requestDTO);

    /**
     * 查询路径所有数据
     * @return
     */
    List<PathModel> selectPathList();

    /**
     * 查询路径列表数据条数
     * @return
     */
    Long selectPathListCount();

    /**
     * 查询单条路径数据详情
     * @param id
     * @return
     */
    PathModel getPathById(Long id);

    /**
     * 编辑路径/关闭路径
     * @param pathModel
     * @return
     */
    int updatePath(PathModel pathModel);
}
