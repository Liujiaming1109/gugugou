package com.gugugou.provider.path.dao;

import com.gugugou.provider.common.RequestDTO;
import com.gugugou.provider.path.model.ItemPathSkuDTO;
import com.gugugou.provider.path.model.PathModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    PathModel getPathById(@Param("id") Long id);

    /**
     * 编辑路径/关闭路径
     * @param pathModel
     * @return
     */
    int updatePath(PathModel pathModel);

    /**
     * 根据路径id查询下面所有的商品id
     * @param id
     * @return
     */
    List<ItemPathSkuDTO> selectItemIdByPathId(@Param("pathId") Long id);

    /**
     * 根据商品路径表外键id查询所有路径价格
     * @param id
     * @return
     */
    List<ItemPathSkuDTO> selectPathPriceByItemPathId(@Param("itemPathId") Long id);
}
