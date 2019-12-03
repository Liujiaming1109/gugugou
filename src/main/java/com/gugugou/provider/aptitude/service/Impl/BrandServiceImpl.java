package com.gugugou.provider.aptitude.service.Impl;

import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import com.gugugou.provider.common.ProviderCentreConsts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class BrandServiceImpl implements BrandService {

   @Resource
   private BrandDao brandDao;

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    @Override
    public Integer addAptitude(BrandModel brandModel) {
        brandModel.setCreatedTime(new Date());
        brandModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
        List<AccessoryUrlModel> trademarkList = brandModel.getTrademarkList();
        for (AccessoryUrlModel accessoryUrlModel : trademarkList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
        }
        brandDao.addAccessoryList(trademarkList);
        List<AccessoryUrlModel> registerList = brandModel.getRegisterList();
        for (AccessoryUrlModel accessoryUrlModel : registerList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ONE);
        }
        brandDao.addAccessoryList(registerList);
        List<AccessoryUrlModel> examiningReportList = brandModel.getExaminingReportList();
        for (AccessoryUrlModel accessoryUrlModel : examiningReportList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_TWO);
        }
        brandDao.addAccessoryList(examiningReportList);
        List<AccessoryUrlModel> productList = brandModel.getProductList();
        for (AccessoryUrlModel accessoryUrlModel : productList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_THREE);
        }
        brandDao.addAccessoryList(productList);
        List<AccessoryUrlModel> foodManufacturerList = brandModel.getFoodManufacturerList();
        for (AccessoryUrlModel accessoryUrlModel : foodManufacturerList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_FOUR);
        }
        brandDao.addAccessoryList(foodManufacturerList);
        List<AccessoryUrlModel> processManufacturerList = brandModel.getProcessManufacturerList();
        for (AccessoryUrlModel accessoryUrlModel : processManufacturerList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_FIVE);
        }
        brandDao.addAccessoryList(processManufacturerList);
        List<AccessoryUrlModel> exitAndEntryList = brandModel.getExitAndEntryList();
        for (AccessoryUrlModel accessoryUrlModel : exitAndEntryList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_SIX);
        }
        brandDao.addAccessoryList(examiningReportList);
        List<AccessoryUrlModel> saltList = brandModel.getSaltList();
        for (AccessoryUrlModel accessoryUrlModel : saltList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_SEVEN);
        }
        brandDao.addAccessoryList(saltList);
        List<AccessoryUrlModel> importList = brandModel.getImportList();
        for (AccessoryUrlModel accessoryUrlModel : importList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_EIGHT);
        }
        brandDao.addAccessoryList(importList);
        List<AccessoryUrlModel> halalFoodList = brandModel.getHalalFoodList();
        for (AccessoryUrlModel accessoryUrlModel : halalFoodList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_NINE);
        }
        brandDao.addAccessoryList(halalFoodList);
        List<AccessoryUrlModel> organicFoodList = brandModel.getOrganicFoodList();
        for (AccessoryUrlModel accessoryUrlModel : organicFoodList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_TEN);
        }
        brandDao.addAccessoryList(organicFoodList);
        List<AccessoryUrlModel> invoiceList = brandModel.getInvoiceList();
        for (AccessoryUrlModel accessoryUrlModel : invoiceList) {
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ELEVEN);
        }
        return brandDao.addAptitude(brandModel);
    }
}
