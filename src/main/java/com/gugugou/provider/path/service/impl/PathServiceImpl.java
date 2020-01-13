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
    @SuppressWarnings("all")
    public Long addPath(PathModel pathModel) {
        pathModel.setCreatedTime(new Date());
        pathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
        pathDao.addPath(pathModel);
        Long id = pathModel.getId();
        PathModel pathById = pathDao.getPathById(id);
        //开始时间
        String pathStartTime = pathById.getPathStartTime();
        //结束时间
        String pathEndTime = pathById.getPathEndTime();
        //路径开启状态：0：启用，1：禁用
        Integer pathCloseOpen = pathById.getPathCloseOpen();
        long now = System.currentTimeMillis();
        PathModel pathModelIn = new PathModel();
        try {
                long pathStartTimeStamp = TimeToStamp.timeToStamp(pathStartTime);
                long pathEndTimeStamp = TimeToStamp.timeToStamp(pathEndTime);
                if (ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
                    if (now < pathStartTimeStamp) {
                        pathModelIn.setId(id);
                        pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                        pathDao.updatePath(pathModelIn);
                    }else if (now >= pathStartTimeStamp && now <= pathEndTimeStamp) {
                        pathModelIn.setId(id);
                        pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                        pathDao.updatePath(pathModel);
                    }else if (now > pathEndTimeStamp) {
                        pathModelIn.setId(id);
                        pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_THREE);
                        pathDao.updatePath(pathModel);
                    }
                }else if (!ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
                        pathModelIn.setId(id);
                        pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
                        pathDao.updatePath(pathModel);
                }
            } catch (ParseException e) {
                throw new RuntimeException("日期解析失败");
            }
                return id;
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
    @SuppressWarnings("all")
    public Integer updatePath(PathModel pathModel) {
        pathModel.setUpdatedTime(new Date());
        pathDao.updatePath(pathModel);
        Long id = pathModel.getId();
        //编辑完路径查询开始和到期时间更改路径状态
        PathModel pathById = pathDao.getPathById(id);
        //开始时间
        String pathStartTime = pathById.getPathStartTime();
        //结束时间
        String pathEndTime = pathById.getPathEndTime();
        //路径开启状态：0：启用，1：禁用
        Integer pathCloseOpen = pathById.getPathCloseOpen();
        long now = System.currentTimeMillis();
        PathModel pathModelIn = new PathModel();
        try {
            long pathStartTimeStamp = TimeToStamp.timeToStamp(pathStartTime);
            long pathEndTimeStamp = TimeToStamp.timeToStamp(pathEndTime);
            if (ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
                if (now < pathStartTimeStamp) {
                    pathModelIn.setId(id);
                    pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                    pathDao.updatePath(pathModelIn);
                }else if (now >= pathStartTimeStamp && now <= pathEndTimeStamp) {
                    pathModelIn.setId(id);
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                    pathDao.updatePath(pathModel);
                }else if (now > pathEndTimeStamp) {
                    pathModelIn.setId(id);
                    pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_THREE);
                    pathDao.updatePath(pathModel);
                }
            }else if (!ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
                pathModelIn.setId(id);
                pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
                pathDao.updatePath(pathModel);
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期解析失败");
        }
        return null;
    }

    /**
     * 关闭/开启路径
     * @param pathModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Integer openOrClosePath(PathModel pathModel) {
        //关闭路径
        if (ProviderCentreConsts.INTEGER_ZERO.equals(pathModel.getPathCloseOpen())) {
            pathModel.setPathCloseOpen(ProviderCentreConsts.INTEGER_ONE);
            pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
            pathModel.setUpdatedTime(new Date());
            pathDao.updatePath(pathModel);
            //开启路径
        }else if (!ProviderCentreConsts.INTEGER_ZERO.equals(pathModel.getPathCloseOpen())) {
            pathModel.setPathCloseOpen(ProviderCentreConsts.INTEGER_ZERO);
            pathDao.updatePath(pathModel);
            //根据id查询数据详情
            PathModel pathById = pathDao.getPathById(pathModel.getId());
            //开始时间
            String pathStartTime = pathById.getPathStartTime();
            //结束时间
            String pathEndTime = pathById.getPathEndTime();
            //路径开启状态：0：启用，1：禁用
            Integer pathCloseOpen = pathById.getPathCloseOpen();
            long now = System.currentTimeMillis();
            PathModel pathModelIn = new PathModel();
            try {
                long start = TimeToStamp.timeToStamp(pathStartTime);
                long end = TimeToStamp.timeToStamp(pathEndTime);
                if (now < start) {
                    pathModelIn.setId(pathModel.getId());
                    pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                    return pathDao.updatePath(pathModelIn);
                }else if (now >= start && now <= end) {
                    pathModelIn.setId(pathModel.getId());
                    pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                    return pathDao.updatePath(pathModelIn);
                }else if(now > end) {
                    pathModelIn.setId(pathModel.getId());
                    pathModelIn.setPathStatus(ProviderCentreConsts.INTEGER_THREE);
                    return pathDao.updatePath(pathModelIn);
                }
            } catch (ParseException e) {
                throw new RuntimeException("日期解析异常");
            }
        }
                return null;
    }

}
