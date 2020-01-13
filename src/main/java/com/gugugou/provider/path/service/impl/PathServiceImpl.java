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
    public Long addOrUpdatePath(PathModel pathModel) {
        //开始时间
        String pathStartTime = pathModel.getPathStartTime();
        //结束时间
        String pathEndTime = pathModel.getPathEndTime();
        //路径开启状态：0：启用，1：禁用
        Integer pathCloseOpen = pathModel.getPathCloseOpen();
        long now = System.currentTimeMillis();
        try {
            long pathStartTimeStamp = TimeToStamp.timeToStamp(pathStartTime);
            long pathEndTimeStamp = TimeToStamp.timeToStamp(pathEndTime);
            if (ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
                if (now < pathStartTimeStamp) {
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                    pathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                }else if (now >= pathStartTimeStamp && now <= pathEndTimeStamp) {
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                    pathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                }else if (now > pathEndTimeStamp) {
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_THREE);
                    pathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                }
            }else if (!ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
                pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
                pathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
            }
            if(pathModel.getId() == null){
                pathModel.setCreatedTime(new Date());
                pathDao.addPath(pathModel);
            } else {
                pathModel.setUpdatedTime(new Date());
                pathDao.updatePath(pathModel);
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期解析失败");
        }
                return null;
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
     * 关闭/开启路径
     * @param pathModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Integer openOrClosePath(PathModel pathModel) {
        //路径开启状态：0：启用，1：禁用
        Integer pathCloseOpen = pathModel.getPathCloseOpen();
        //关闭路径
        if (!ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
            pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
            pathModel.setUpdatedTime(new Date());
            pathDao.updatePath(pathModel);
            //开启路径
        }else if (ProviderCentreConsts.INTEGER_ZERO.equals(pathCloseOpen)) {
            //开始时间
            String pathStartTime = pathModel.getPathStartTime();
            //结束时间
            String pathEndTime = pathModel.getPathEndTime();
            long now = System.currentTimeMillis();
            try {
                long start = TimeToStamp.timeToStamp(pathStartTime);
                long end = TimeToStamp.timeToStamp(pathEndTime);
                if (now < start) {
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                    pathModel.setUpdatedTime(new Date());
                    return pathDao.updatePath(pathModel);
                }else if (now >= start && now <= end) {
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                    return pathDao.updatePath(pathModel);
                }else if(now > end) {
                    pathModel.setPathStatus(ProviderCentreConsts.INTEGER_THREE);
                    return pathDao.updatePath(pathModel);
                }
            } catch (ParseException e) {
                throw new RuntimeException("日期解析异常");
            }
        }
                return null;
    }

}
