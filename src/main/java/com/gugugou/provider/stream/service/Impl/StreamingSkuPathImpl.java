package com.gugugou.provider.stream.service.Impl;

import com.gugugou.provider.commodity.dto.model.UpdateSkuPathModel;
import com.gugugou.provider.commodity.dto.request.UpdateSkuPathListRequest;

import com.gugugou.provider.commodity.model.SkuPathModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.stream.dao.StreamingSkuPthDao;

import com.gugugou.provider.stream.service.StreamingSkuPathService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StreamingSkuPathImpl implements StreamingSkuPathService {


    @Resource
    private StreamingSkuPthDao streamingSkuPthDao;

    /**设置排班间商品sku的扣点*/
    @Override
    public int updateStreamingSkuPath(SkuPathModel skuPathModel) {
        SkuPathModel skuPathById = streamingSkuPthDao.getSkuPathById(skuPathModel);
        if (skuPathById != null) {
            skuPathModel.setUpdatedTime(new Date());
            streamingSkuPthDao.updateStreamingSkuPath(skuPathModel);
        }else {
            skuPathModel.setCreatedTime(new Date());
            skuPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
            streamingSkuPthDao.insertSkuPath(skuPathModel);
        }
        return 1;
    }

    /**批量修改排班间商品的*/
    @Override
    public Integer updateStreamingkuPointList(UpdateSkuPathListRequest updateSkuPathListRequest) {
        List<UpdateSkuPathModel> updateSkuPathModels = updateSkuPathListRequest.getUpdateSkuPathModels();
        if (!updateSkuPathModels.isEmpty()) {
            for (UpdateSkuPathModel updateSkuPathModel:updateSkuPathModels) {
                Long id = updateSkuPathModel.getId();
                SkuPathModel skuPathById = streamingSkuPthDao.getStreamingSkuById(id);
                if (skuPathById != null) {
                    SkuPathModel skuPathModel = new SkuPathModel();
                    skuPathModel.setId(id);
                    skuPathModel.setPoint(updateSkuPathListRequest.getPoint());
                    skuPathModel.setUpdatedTime(new Date());
                    streamingSkuPthDao.updateStreamingSkuPoint(skuPathModel);
                }else {
                    SkuPathModel skuPathModel = new SkuPathModel();
                    skuPathModel.setSkuId(updateSkuPathListRequest.getSkuId());
                    skuPathModel.setPoint(updateSkuPathListRequest.getPoint());
                    skuPathModel.setProviderId(updateSkuPathModel.getProviderId());
                    skuPathModel.setRemoved(ProviderCentreConsts.INTEGER_ZERO);
                    skuPathModel.setCreatedTime(new Date());
                    streamingSkuPthDao.insertSkuPath(skuPathModel);
                }
            }
        }
        return null;
    }

    /**查找路径下的扣点列表*/
    @Override
    public ResponseDTO findStreamingSkuPoints(SkuPathModel skuPathModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (skuPathModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(skuPathModel.getPageSize());
        skuPathModel.setPageIndex(pageIndex);
        List<SkuPathModel> skuPathModelList = streamingSkuPthDao.selectPathPointListByPage(skuPathModel);
        if (!skuPathModelList.isEmpty()) {
            responseDTO.setData(skuPathModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = streamingSkuPthDao.selectPathPointCountByPage(skuPathModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**根据路径id和skuId查询所有路径库存数据*/
   /* @Override
    public ResponseDTO selecStreamingPath(InventoryModel inventoryModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (inventoryModel.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*(inventoryModel.getPageSize());
        inventoryModel.setPageIndex(pageIndex);
        List<InventoryModel> inventoryModelList = streamingSkuPthDao.selectPathRealQuantityBySkuIdAndPathId(inventoryModel);
        if (!inventoryModelList.isEmpty()) {
            for (InventoryModel inventoryModels:inventoryModelList) {
                String warehouseCode = inventoryModels.getWarehouseCode();
                inventoryModel.setWarehouseCode(warehouseCode);
                InventoryModel inventoryModel1 = streamingSkuPthDao.selectRealQuantityBySkuIdAndWareHouse(inventoryModel);
                inventoryModel1.setPathQuantity(inventoryModel1.getRealQuantity());
            }
            responseDTO.setData(inventoryModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = streamingSkuPthDao.selectPathRealQuantityCountBySkuIdAndPathId(inventoryModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }*/
}
