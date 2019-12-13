package com.gugugou.provider.commodity.service.Impl;

import com.gugugou.provider.commodity.DTO.RequestDTO;
import com.gugugou.provider.commodity.dao.PathDao;
import com.gugugou.provider.commodity.model.PathModel;
import com.gugugou.provider.commodity.service.PathService;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: PathServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/11 17:01
 */
@Service
@Transactional
public class PathServiceImpl implements PathService {

    @Resource
    private PathDao pathDao;

    /**
     * 添加路径
     * @param pathModel
     * @return
     */
    @Override
    public Long addPath(PathModel pathModel) {
        pathModel.setCreatedTime(new Date());
        pathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
        pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
        return pathDao.addPath(pathModel);
    }

    /**
     * 分页查询路径列表
     * @param requestDTO
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectPathListByPage(RequestDTO requestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (requestDTO.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(requestDTO.getPageSize());
        requestDTO.setPageIndex(pageIndex);
        List<PathModel> pathModelList = pathDao.selectPathListByPage(requestDTO);
        if (!pathModelList.isEmpty()) {
            responseDTO.setData(pathModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = pathDao.selectPathListCount();
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 查询单条路径数据详情
     * @param id
     * @return
     */
    @Override
    public PathModel getPathById(Long id) {
        return pathDao.getPathById(id);
    }

    /**
     * 编辑路径
     * @param pathModel
     * @return
     */
    @Override
    public Integer updatePath(PathModel pathModel) {
        pathModel.setUpdatedTime(new Date());
        return pathDao.updatePath(pathModel);
    }

    /**
     * 关闭路径
     * @param pathModel
     * @return
     */
    @Override
    public Integer closePath(PathModel pathModel) {
        pathModel.setUpdatedTime(new Date());
        pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
        return pathDao.updatePath(pathModel);
    }

    /**
     * 开启路径
     * @param pathModel
     * @return
     */
    @Override
    public Integer openPath(PathModel pathModel) {
        pathModel.setUpdatedTime(new Date());
        pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
        return pathDao.updatePath(pathModel);
    }
}
