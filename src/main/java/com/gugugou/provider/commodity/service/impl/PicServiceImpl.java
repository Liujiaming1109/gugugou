package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.commodity.dao.PicDao;
import com.gugugou.provider.commodity.model.PicModel;
import com.gugugou.provider.commodity.service.PicService;
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
 * @Title: PicServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/26 12:14
 */
@Service
@Transactional
public class PicServiceImpl implements PicService {

    @Resource
    private PicDao picDao;

    /**
     *新增图片
     * @param picModel
     * @return
     */
    @Override
    public Long insertPic(PicModel picModel) {
        picModel.setPicStatus(ProviderCentreConsts.INTEGER_ZERO);
        picModel.setCreatedTime(new Date());
        picModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
        return picDao.insertPic(picModel);
    }

    /**
     * 批量新增图片
     * @param picModels
     * @return
     */
    @Override
    public List<Long> insertPicList(List<PicModel> picModels) {
        if (!picModels.isEmpty()) {
            for (PicModel picModel:picModels) {
                picModel.setPicStatus(ProviderCentreConsts.INTEGER_ZERO);
                picModel.setCreatedTime(new Date());
                picModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
            }
        }
        return picDao.insertPicList(picModels);
    }

    /**
     * 分页条件查询图片列表
     * @param picModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectPicListByPage(PicModel picModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (picModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(picModel.getPageSize());
        picModel.setPageIndex(pageIndex);
        List<PicModel> picModels = picDao.selectPicListByPage(picModel);
        if (!picModels.isEmpty()) {
            responseDTO.setData(picModels);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = picDao.selectPicListCount(picModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     *  分页查询已发布图片列表
     * @param picModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectPicReleaseListByPage(PicModel picModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (picModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(picModel.getPageSize());
        picModel.setPageIndex(pageIndex);
        picModel.setPicStatus(ProviderCentreConsts.INTEGER_ONE);
        List<PicModel> picModels = picDao.selectPicListByPage(picModel);
        if (!picModels.isEmpty()) {
            responseDTO.setData(picModels);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = picDao.selectPicListCount(picModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 根据id查看数据详情
     * @param id
     * @return
     */
    @Override
    public PicModel getPicById(Long id) {
        return picDao.getPicById(id);
    }

    /**
     * 根据id删除数据
     * @param picModel
     * @return
     */
    @Override
    public Integer deleteById(PicModel picModel) {
        picModel.setRemoved(ProviderCentreConsts.INTEGER_ONE);
        picModel.setUpdatedTime(new Date());
        return picDao.deleteById(picModel);
    }

    /**
     * 编辑图片信息
     * @param picModel
     * @return
     */
    @Override
    public Integer updatePic(PicModel picModel) {
        picModel.setUpdatedTime(new Date());
        return picDao.updatePic(picModel);
    }

    /**
     * 修改发布状态
     * @param picModel
     * @return
     */
    @Override
    public Integer updatedPicStatus(PicModel picModel) {
        Integer picStatus = picModel.getPicStatus();
        //关闭
        if (0==picStatus) {
            picModel.setUpdatedTime(new Date());
            return picDao.updatePic(picModel);
        //开启
        }else if (1==picStatus) {
            Integer picType = picModel.getPicType();
            //查询已发布的图片数量
            Long count = picDao.selectPicListCount(picModel);
            if (0==picType) {
                if (count > ProviderCentreConsts.INTEGER_THREE) {
                    throw new RuntimeException("图片发布不能超过三张");
                }else {
                    return picDao.updatePic(picModel);
                }
            }else if (1==picType) {
                if (count > ProviderCentreConsts.INTEGER_ONE) {
                    throw new RuntimeException("图片发布不能超过一张");
                }else {
                    return picDao.updatePic(picModel);
                }
            }else if (ProviderCentreConsts.INTEGER_TWO.equals(picType)) {
                if (count > ProviderCentreConsts.INTEGER_THREE) {
                    throw new RuntimeException("图片发布不能超过三张");
                }else {
                    return picDao.updatePic(picModel);
                }
            }
        }
        return null;
    }
}
