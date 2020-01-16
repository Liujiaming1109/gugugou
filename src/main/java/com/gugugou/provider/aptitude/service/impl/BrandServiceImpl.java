package com.gugugou.provider.aptitude.service.impl;

import com.gugugou.provider.aptitude.dto.response.BrandResponseDTO;
import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import com.gugugou.provider.commodity.dao.SkuPathDao;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.common.until.DaysToMillis;
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
 * @Title: BrandServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 15:36
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

   @Resource
   private BrandDao brandDao;
   @Resource
   private SkuPathDao skuPathDao;

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Long addAptitude(BrandModel brandModel) {
        List<BrandModel> brandModelList = brandDao.selectProviderPriorityList(brandModel);
        //授权开始日期和结束日期
        String trademarkStartDate = String.valueOf(brandModel.getTrademarkStartDate());
        String trademarkEndDate = brandModel.getTrademarkEndDate();
        if (!brandModelList.isEmpty()) {
            brandModel.setSendOrderWeight(brandModelList.get(0).getSendOrderWeight()+ProviderCentreConsts.INTEGER_ONE);
        }else {
            brandModel.setSendOrderWeight(ProviderCentreConsts.INTEGER_ONE);
        }
        long now = System.currentTimeMillis();
        try {
            long start = TimeToStamp.timeToStamp(trademarkStartDate);
                if (now < start) {
                    brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_THREE);
                }else {
                    if ("长期".equals(trademarkEndDate)) {
                        brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ZERO);
                    }else {
                        long end = TimeToStamp.timeToStamp(trademarkEndDate);
                        //小于三十天为即将过期
                        long corn = DaysToMillis.daysToMillis(30L);
                        if (end - now >= 0 && end - now <= corn) {
                            brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ONE);
                        }
                        if (end - now > corn) {
                            brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ZERO);
                        }
                        if (end - now < 0) {
                            brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_TWO);
                        }
                    }
                }
        } catch (ParseException e) {
            throw new RuntimeException("日期解析失败");
        }
        brandModel.setCreatedTime(new Date());
        brandModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
        brandDao.addAptitude(brandModel);
        Long id = brandModel.getId();
        List<AccessoryUrlModel> trademarkList = brandModel.getTrademarkList();
        if (!trademarkList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : trademarkList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
            }
            brandDao.addAccessoryList(trademarkList);
        }
        List<AccessoryUrlModel> registerList = brandModel.getRegisterList();
        if (!registerList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : registerList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ONE);
            }
            brandDao.addAccessoryList(registerList);
        }
        List<AccessoryUrlModel> examiningReportList = brandModel.getExaminingReportList();
        if (!examiningReportList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : examiningReportList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_TWO);
            }
            brandDao.addAccessoryList(examiningReportList);
        }
        List<AccessoryUrlModel> productList = brandModel.getProductList();
        if (!productList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : productList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_THREE);
            }
            brandDao.addAccessoryList(productList);
        }
        List<AccessoryUrlModel> foodManufacturerList = brandModel.getFoodManufacturerList();
        if (!foodManufacturerList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : foodManufacturerList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_FOUR);
            }
            brandDao.addAccessoryList(foodManufacturerList);
        }
        List<AccessoryUrlModel> processManufacturerList = brandModel.getProcessManufacturerList();
        if (!processManufacturerList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : processManufacturerList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_FIVE);
            }
            brandDao.addAccessoryList(processManufacturerList);
        }
        List<AccessoryUrlModel> exitAndEntryList = brandModel.getExitAndEntryList();
        if (!exitAndEntryList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : exitAndEntryList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_SIX);
            }
            brandDao.addAccessoryList(examiningReportList);
        }
        List<AccessoryUrlModel> saltList = brandModel.getSaltList();
        if (!saltList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : saltList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_SEVEN);
            }
            brandDao.addAccessoryList(saltList);
        }
        List<AccessoryUrlModel> importList = brandModel.getImportList();
        if (!importList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : importList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_EIGHT);
            }
            brandDao.addAccessoryList(importList);
        }
        List<AccessoryUrlModel> halalFoodList = brandModel.getHalalFoodList();
        if (!halalFoodList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : halalFoodList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_NINE);
            }
            brandDao.addAccessoryList(halalFoodList);
        }
        List<AccessoryUrlModel> organicFoodList = brandModel.getOrganicFoodList();
        if (!organicFoodList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : organicFoodList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_TEN);
            }
            brandDao.addAccessoryList(organicFoodList);
        }
        List<AccessoryUrlModel> invoiceList = brandModel.getInvoiceList();
        if (!invoiceList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : invoiceList) {
                accessoryUrlModel.setBrandIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ELEVEN);
            }
            brandDao.addAccessoryList(invoiceList);
        }
            return id;
    }

    /**
     * 带条件分页查询
     * @param brandModel
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public ResponseDTO selectAptitudeListByPage(BrandModel brandModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (brandModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(brandModel.getPageSize());
        brandModel.setPageIndex(pageIndex);
        List<BrandModel> brandModelList = brandDao.selectAptitudeListByPage(brandModel);
        if (!brandModelList.isEmpty()) {
            responseDTO.setData(brandModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Long count = brandDao.selectAptitudeListCount(brandModel);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 查询单条品牌资质数据明细
     * @param id
     * @return
     */
    @Override
    public BrandResponseDTO getAptitudeById(Long id) {
        BrandResponseDTO brandResponseDTO = new BrandResponseDTO();
        BrandModel aptitudeById = brandDao.getAptitudeById(id);
        if (aptitudeById != null && !("").equals(aptitudeById)) {
            brandResponseDTO.setBrandModel(aptitudeById);
        }
        List<AccessoryUrlModel> accessoryByBrandIdFk = brandDao.getAccessoryByBrandIdFk(id);
        if (!accessoryByBrandIdFk.isEmpty()) {
            brandResponseDTO.setAccessoryUrlModelList(accessoryByBrandIdFk);
        }
        return  brandResponseDTO;
    }

    /**
     * 编辑品牌资质
     * @param brandModel
     * @return
     */
    @SuppressWarnings("all")
    @Override
    public Integer updateAptitude(BrandModel brandModel) {
        String trademarkStartDate = String.valueOf(brandModel.getTrademarkStartDate());
        String trademarkEndDate = brandModel.getTrademarkEndDate();
        long now = System.currentTimeMillis();
        try {
            long start = TimeToStamp.timeToStamp(trademarkStartDate);
            if (now < start) {
                brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_THREE);
            }else {
                if ("长期".equals(trademarkEndDate)) {
                    brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ZERO);
                }else {
                    long end = TimeToStamp.timeToStamp(trademarkEndDate);
                    //小于三十天为即将过期
                    long corn = DaysToMillis.daysToMillis(30L);
                    if (end - now >= 0 && end - now <= corn) {
                        brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ONE);
                    }
                    if (end - now > corn) {
                        brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ZERO);
                    }
                    if (end - now < 0) {
                        brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_TWO);
                    }
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期解析失败");
        }
        brandModel.setUpdatedTime(new Date());
        int aptitude = brandDao.updateAptitude(brandModel);
        List<AccessoryUrlModel> trademarkList = brandModel.getTrademarkList();
        if (!trademarkList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : trademarkList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> registerList = brandModel.getRegisterList();
        if (!registerList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : registerList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> examiningReportList = brandModel.getExaminingReportList();
        if (!examiningReportList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : examiningReportList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> productList = brandModel.getProductList();
        if (!productList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : productList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> foodManufacturerList = brandModel.getFoodManufacturerList();
        if (!foodManufacturerList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : foodManufacturerList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> processManufacturerList = brandModel.getProcessManufacturerList();
        if (!processManufacturerList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : processManufacturerList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> exitAndEntryList = brandModel.getExitAndEntryList();
        if (!exitAndEntryList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : exitAndEntryList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> saltList = brandModel.getSaltList();
        if (!saltList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : saltList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> importList = brandModel.getImportList();
        if (!importList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : importList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> halalFoodList = brandModel.getHalalFoodList();
        if (!halalFoodList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : halalFoodList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> organicFoodList = brandModel.getOrganicFoodList();
        if (!organicFoodList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : organicFoodList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        List<AccessoryUrlModel> invoiceList = brandModel.getInvoiceList();
        if (!invoiceList.isEmpty()) {
            for (AccessoryUrlModel accessoryUrlModel : invoiceList) {
                accessoryUrlModel.setUpdatedTime(new Date());
                brandDao.updateAccessory(accessoryUrlModel);
            }
        }
        return aptitude;
    }

    /**
     * 删除品牌资质附件
     * @param accessoryUrlModel
     * @return
     */
    @Override
    public Integer deleteAccessory(AccessoryUrlModel accessoryUrlModel) {
        accessoryUrlModel.setUpdatedTime(new Date());
        return brandDao.deleteAccessory(accessoryUrlModel);
    }

    /**
     * 查询品牌在该类目下的其他供应商优先级
     * @param brandModel
     * @return
     */
    @Override
    public List<BrandModel> selectProviderPriorityListOne(BrandModel brandModel) {
        return brandDao.selectProviderPriorityList(brandModel);
    }

    /**
     * 修改派单优先级
     * @param brandModel
     * @return
     */
    @Override
    public Integer updateProvider(BrandModel brandModel) {
        //已经存在的派单权重
        Integer sendOrderWeightExist = brandModel.getSendOrderWeight();
        //修改派单权重入参
        Integer sendOrderWeightIn = brandModel.getSendOrderWeightIn();
        brandModel.setSendOrderWeight(sendOrderWeightIn);
        List<BrandModel> brandModelList = brandDao.selectProviderPriorityListOne(brandModel);
        if (!brandModelList.isEmpty()) {
            if (sendOrderWeightExist > sendOrderWeightIn) {
                List<BrandModel> subList = brandModelList.subList(sendOrderWeightIn - ProviderCentreConsts.INTEGER_ONE, sendOrderWeightExist - ProviderCentreConsts.INTEGER_ONE);
                for (BrandModel brandModels:subList) {
                    brandModels.setSendOrderWeight(brandModels.getSendOrderWeight() + ProviderCentreConsts.INTEGER_ONE);
                    brandModels.setUpdatedTime(new Date());
                    brandDao.updateProvider(brandModel);
                }
            }else if (sendOrderWeightExist < sendOrderWeightIn) {
                List<BrandModel> subList = brandModelList.subList(sendOrderWeightIn, sendOrderWeightExist);
                for (BrandModel brandModels:subList) {
                    brandModels.setSendOrderWeight(brandModels.getSendOrderWeight() - ProviderCentreConsts.INTEGER_ONE);
                    brandModels.setUpdatedTime(new Date());
                    brandDao.updateProvider(brandModel);
                }
            }
        }
                return brandDao.updateProvider(brandModel);
    }

    /**
     * 关闭派单权重
     * @param brandModel
     * @return
     */
    @Override
    public Integer closeProvider(BrandModel brandModel) {
        brandModel.setSendOrderWeight(ProviderCentreConsts.INTEGER_ZERO);
        brandModel.setUpdatedTime(new Date());
        return brandDao.updateProvider(brandModel);
    }

    /**
     * 查询品牌在该类目下的其他供应商（扣点降序）
     * @param brandModel
     * @return
     */
    @Override
    public List<BrandModel> selectProviderBucklePointList(BrandModel brandModel) {
        return brandDao.selectProviderBucklePointList(brandModel);
    }

    /**
     * 修改扣点
     * @param brandModel
     * @return
     */
    @Override
    public Integer updateBucklePoint(BrandModel brandModel) {
        brandModel.setUpdatedTime(new Date());
        return brandDao.updateBucklePoint(brandModel);
    }
}
