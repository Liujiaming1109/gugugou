package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.commodity.dao.ItemDao;
import com.gugugou.provider.commodity.dao.SkuDao;
import com.gugugou.provider.commodity.dao.SkuPathDao;
import com.gugugou.provider.commodity.dto.model.UpdateSkuPathModel;
import com.gugugou.provider.commodity.dto.request.UpdatePathPointListRequest;
import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;
import com.gugugou.provider.commodity.model.ItemModel;
import com.gugugou.provider.commodity.model.SkuModel;
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
    private ItemDao itemDao;
    @Resource
    private SkuDao skuDao;

    /**
     * 修改扣点
     * @param skuPathModel
     * @return
     */
    @Override
    public Integer updateSkuPoint(SkuPathModel skuPathModel) {
        Long id = skuPathModel.getId();
        SkuPathModel skuPathById = skuPathDao.getSkuPathById(id);
        if (skuPathById != null) {
            skuPathModel.setUpdatedTime(new Date());
            skuPathDao.updateSkuPoint(skuPathModel);
        }else {
            skuPathModel.setCreatedTime(new Date());
            skuPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
            skuPathDao.insertSkuPath(skuPathModel);
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

    /**
     * 带分页条件搜索商品
     * @param itemModel
     * @return
     */
    @Override
    public ResponseDTO searchItemList(ItemModel itemModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<ItemModel> itemModelList = itemDao.searchItemList(itemModel);
        if (!itemModelList.isEmpty()) {
            responseDTO.setData(itemModelList);
        }
        Long count = itemDao.searchItemListCount(itemModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 带条件搜索sku
     * @param skuModel
     * @return
     */
    @Override
    public List<SkuModel> searchSku(SkuModel skuModel) {
        ArrayList<Long> ids = new ArrayList<>();
        ArrayList<SkuModel> skuModelArrayList = new ArrayList<>();
        List<SkuPathModel> skuPathModelList = skuPathDao.selectSkuIdByPathIdAndItemId(skuModel.getItemId(), skuModel.getPathId());
        List<SkuModel> skuModelList = skuDao.searchSku(skuModel);
        if (!skuModelList.isEmpty()) {
            for (SkuModel skuModel1:skuModelList) {
               if (!skuPathModelList.isEmpty()) {
                   for (SkuPathModel skuPathModel:skuPathModelList) {
                       if (!skuModel1.getId().equals(skuPathModel.getSkuId())) {
                           ids.add(skuModel1.getId());
                       }
                   }
               }
            }
        }
        if (!ids.isEmpty()) {
            SkuModel skuModel1 = new SkuModel();
            for (Long id:ids) {
                SkuModel searchSku = skuDao.searchSku(id);
                skuModelArrayList.add(searchSku);
            }
        }
        return skuModelArrayList;
    }


}
