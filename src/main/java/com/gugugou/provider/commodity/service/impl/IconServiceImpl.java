package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.commodity.dao.IconDao;
import com.gugugou.provider.commodity.model.IconModel;
import com.gugugou.provider.commodity.service.IconService;
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
 * @Title: IconServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/31 16:05
 */
@Service
@Transactional
public class IconServiceImpl implements IconService {

    @Resource
    private IconDao iconDao;

    /**
     * 新增图片
     * @param iconModel
     * @return
     */
    @Override
    public Long insertIcon(IconModel iconModel) {
        iconModel.setLogoStatus(ProviderCentreConsts.INTEGER_ZERO);
        iconModel.setCreatedTime(new Date());
        iconModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
        return iconDao.insertIcon(iconModel);
    }

    /**
     * 批量新增图片
     * @param iconModels
     * @return
     */
    @Override
    public List<Long> insertIconList(List<IconModel> iconModels) {
        if (!iconModels.isEmpty()) {
            for (IconModel iconModel:iconModels) {
                iconModel.setLogoStatus(ProviderCentreConsts.INTEGER_ZERO);
                iconModel.setCreatedTime(new Date());
                iconModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
            }
        }
        return iconDao.insertIconList(iconModels);
    }

    /**
     * 分页条件查询图片列表
     * @param iconModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectIconListByPage(IconModel iconModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (iconModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(iconModel.getPageSize());
        iconModel.setPageIndex(pageIndex);
        List<IconModel> iconModels = iconDao.selectIconListByPage(iconModel);
        if (!iconModels.isEmpty()) {
            responseDTO.setData(iconModel);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = iconDao.selectIconListCount(iconModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 分页查询已发布图片列表
     * @param iconModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectIconReleaseListByPage(IconModel iconModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (iconModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(iconModel.getPageSize());
        iconModel.setPageIndex(pageIndex);
        iconModel.setLogoStatus(ProviderCentreConsts.INTEGER_ONE);
        List<IconModel> iconModels = iconDao.selectIconListByPage(iconModel);
        if (!iconModels.isEmpty()) {
            responseDTO.setData(iconModels);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = iconDao.selectIconListCount(iconModel);
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
    public IconModel getIconById(Long id) {
        return iconDao.getIconById(id);
    }

    /**
     * 根据id删除数据
     * @param iconModel
     * @return
     */
    @Override
    public Integer deleteById(IconModel iconModel) {
        iconModel.setRemoved(ProviderCentreConsts.INTEGER_ONE);
        iconModel.setUpdatedTime(new Date());
        return iconDao.deleteById(iconModel);
    }

    /**
     * 编辑图片信息/修改发布状态
     * @param iconModel
     * @return
     */
    @Override
    public Integer updateIcon(IconModel iconModel) {
        iconModel.setUpdatedTime(new Date());
        return iconDao.updateIcon(iconModel);
    }
}
