package com.gugugou.provider.path.service.impl;

import com.gugugou.provider.common.RequestDTO;
import com.gugugou.provider.path.dao.PathDao;
import com.gugugou.provider.path.model.PathModel;
import com.gugugou.provider.path.service.PathService;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.common.until.TimeToStamp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
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
        pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
        pathDao.addPath(pathModel);
        return pathModel.getId();
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
        pathModel.setPathCloseOpen(ProviderCentreConsts.INTEGER_ONE);
        pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
        return pathDao.updatePath(pathModel);
    }

    /**
     * 开启路径
     * @param pathModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Integer openPath(PathModel pathModel) {
        Long id = pathModel.getId();
        PathModel pathById = pathDao.getPathById(id);
        String pathStartTime = pathById.getPathStartTime();
        String pathEndTime = pathById.getPathEndTime();
        long now = System.currentTimeMillis();
        PathModel pathModelUpdate = new PathModel();
        pathModelUpdate.setUpdatedTime(new Date());
        pathModelUpdate.setPathCloseOpen(ProviderCentreConsts.INTEGER_ZERO);
        try {
            long start = TimeToStamp.timeToStamp(pathStartTime);
            long end = TimeToStamp.timeToStamp(pathEndTime);
            if (now < start) {
                pathModelUpdate.setId(id);
                pathModelUpdate.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                return pathDao.updatePath(pathModel);
            }else if (now >= start && now <= end) {
                pathModelUpdate.setId(id);
                pathModelUpdate.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                return pathDao.updatePath(pathModel);
            }else if(now > end) {
                throw new RuntimeException("路径过期，请重新设置");
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期解析异常");
        }
                return null;
    }

}
