package com.gugugou.provider.path.service;

import com.gugugou.provider.common.RequestDTO;
import com.gugugou.provider.path.model.PathModel;
import com.gugugou.provider.common.ResponseDTO;


/**
 * @author: chengShaoShao
 * @Title: PathService
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/11 17:00
 */
public interface PathService {

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
    ResponseDTO selectPathListByPage(RequestDTO requestDTO);

    /**
     * 查询单条路径数据详情
     * @param id
     * @return
     */
    PathModel getPathById(Long id);

    /**
     * 编辑路径
     * @param pathModel
     * @return
     */
    Integer updatePath(PathModel pathModel);

    /**
     * 关闭路径
     * @param pathModel
     * @return
     */
    Integer closePath(PathModel pathModel);

    /**
     * 开启路径
     * @param pathModel
     * @return
     */
    Integer openPath(PathModel pathModel);


}
