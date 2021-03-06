package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.dto.request.BrandSkuPathRequestDTO;
import com.gugugou.provider.aptitude.dto.response.BrandSkuPathResponseDTO;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.commodity.dao.SkuPathDao;
import com.gugugou.provider.commodity.dto.model.UpdateSkuPathModel;
import com.gugugou.provider.commodity.dto.request.UpdatePathPointListRequest;
import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;
import com.gugugou.provider.commodity.dto.response.SkuPathResponseDTO;
import com.gugugou.provider.commodity.model.SkuPathModel;
import com.gugugou.provider.commodity.service.SkuPathService;
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
 * @Title: SkuPointServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/27 15:36
 */
@Service
@Transactional
public class SkuPathServiceImpl implements SkuPathService {

    @Resource
    private SkuPathDao skuPathDao;
    @Resource
    private BrandDao brandDao;

    /**
     * 修改扣点
     * @param skuPathModel
     * @return
     */
    @Override
    public Integer updateSkuPoint(SkuPathModel skuPathModel) {
        Long skuId = skuPathModel.getSkuId();
        if (skuId == null && "".equals(skuId)) {
            skuPathModel.setCreatedTime(new Date());
            skuPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
            Long aLong = skuPathDao.insertSkuPath(skuPathModel);
        }else {
            skuPathModel.setUpdatedTime(new Date());
            int i = skuPathDao.updateSkuPoint(skuPathModel);
        }
        return null;
    }

    /**
     * 批量修改扣点
     * @param updateSkuPathListRequest
     * @return
     */
    @Override
    public Integer updateSkuPointList(UpdateSkuPathListRequest updateSkuPathListRequest) {
        List<UpdateSkuPathModel> updateSkuPathModels = updateSkuPathListRequest.getUpdateSkuPathModels();
        if (!updateSkuPathModels.isEmpty()) {
            for (UpdateSkuPathModel updateSkuPathModel:updateSkuPathModels) {
                Long id = updateSkuPathModel.getId();
                SkuPathModel skuPathById = skuPathDao.getSkuPathById(id);
                if (skuPathById != null) {
                    SkuPathModel skuPathModel = new SkuPathModel();
                    skuPathModel.setId(id);
                    skuPathModel.setPoint(updateSkuPathListRequest.getPoint());
                    skuPathModel.setUpdatedTime(new Date());
                    skuPathDao.updateSkuPoint(skuPathModel);
                }else {
                    SkuPathModel skuPathModel = new SkuPathModel();
                    skuPathModel.setSkuId(updateSkuPathListRequest.getSkuId());
                    skuPathModel.setPoint(updateSkuPathListRequest.getPoint());
                    skuPathModel.setProviderId(updateSkuPathModel.getProviderId());
                    skuPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                    skuPathModel.setCreatedTime(new Date());
                    skuPathDao.insertSkuPath(skuPathModel);
                }
            }
        }
                 return null;
    }

    /**
     * 查询路径下的扣点列表
     * @param skuPathModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectPathPointListByPage(SkuPathModel skuPathModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (skuPathModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(skuPathModel.getPageSize());
        skuPathModel.setPageIndex(pageIndex);
        List<SkuPathModel> skuPathModelList = skuPathDao.selectPathPointListByPage(skuPathModel);
        if (!skuPathModelList.isEmpty()) {
            responseDTO.setData(skuPathModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = skuPathDao.selectPathPointCountByPage(skuPathModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 修改路径扣点
     * @param skuPathModel
     * @return
     */
    @Override
    public Integer updatePathPoint(SkuPathModel skuPathModel) {
        skuPathModel.setUpdatedTime(new Date());
        return skuPathDao.updatePathPoint(skuPathModel);
    }

    /**
     * 批量修改路径扣点
     * @param updatePathPointListRequest
     * @return
     */
    @Override
    public Integer updatePathPointList(UpdatePathPointListRequest updatePathPointListRequest) {
        List<Long> ids = updatePathPointListRequest.getIds();
        SkuPathModel skuPathModel = new SkuPathModel();
        skuPathModel.setPoint(updatePathPointListRequest.getPoint());
        if (!ids.isEmpty()) {
            for (Long id:ids) {
                skuPathModel.setId(id);
                skuPathModel.setUpdatedTime(new Date());
                skuPathDao.updatePathPoint(skuPathModel);
            }
        }
        return null;
    }




}
