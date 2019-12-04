package com.gugugou.provider.aptitude.service.Impl;

import com.gugugou.provider.aptitude.dto.BrandResponseDTO;
import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
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

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    @Override
    public Integer addAptitude(BrandModel brandModel) {
        brandModel.setCreatedTime(new Date());
        brandModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
        brandDao.addAptitude(brandModel);
        Integer id = brandModel.getId();
        List<AccessoryUrlModel> trademarkList = brandModel.getTrademarkList();
        for (AccessoryUrlModel accessoryUrlModel : trademarkList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
        }
        brandDao.addAccessoryList(trademarkList);
        List<AccessoryUrlModel> registerList = brandModel.getRegisterList();
        for (AccessoryUrlModel accessoryUrlModel : registerList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ONE);
        }
        brandDao.addAccessoryList(registerList);
        List<AccessoryUrlModel> examiningReportList = brandModel.getExaminingReportList();
        for (AccessoryUrlModel accessoryUrlModel : examiningReportList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_TWO);
        }
        brandDao.addAccessoryList(examiningReportList);
        List<AccessoryUrlModel> productList = brandModel.getProductList();
        for (AccessoryUrlModel accessoryUrlModel : productList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_THREE);
        }
        brandDao.addAccessoryList(productList);
        List<AccessoryUrlModel> foodManufacturerList = brandModel.getFoodManufacturerList();
        for (AccessoryUrlModel accessoryUrlModel : foodManufacturerList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_FOUR);
        }
        brandDao.addAccessoryList(foodManufacturerList);
        List<AccessoryUrlModel> processManufacturerList = brandModel.getProcessManufacturerList();
        for (AccessoryUrlModel accessoryUrlModel : processManufacturerList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_FIVE);
        }
        brandDao.addAccessoryList(processManufacturerList);
        List<AccessoryUrlModel> exitAndEntryList = brandModel.getExitAndEntryList();
        for (AccessoryUrlModel accessoryUrlModel : exitAndEntryList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_SIX);
        }
        brandDao.addAccessoryList(examiningReportList);
        List<AccessoryUrlModel> saltList = brandModel.getSaltList();
        for (AccessoryUrlModel accessoryUrlModel : saltList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_SEVEN);
        }
        brandDao.addAccessoryList(saltList);
        List<AccessoryUrlModel> importList = brandModel.getImportList();
        for (AccessoryUrlModel accessoryUrlModel : importList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_EIGHT);
        }
        brandDao.addAccessoryList(importList);
        List<AccessoryUrlModel> halalFoodList = brandModel.getHalalFoodList();
        for (AccessoryUrlModel accessoryUrlModel : halalFoodList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_NINE);
        }
        brandDao.addAccessoryList(halalFoodList);
        List<AccessoryUrlModel> organicFoodList = brandModel.getOrganicFoodList();
        for (AccessoryUrlModel accessoryUrlModel : organicFoodList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_TEN);
        }
        brandDao.addAccessoryList(organicFoodList);
        List<AccessoryUrlModel> invoiceList = brandModel.getInvoiceList();
        for (AccessoryUrlModel accessoryUrlModel : invoiceList) {
            accessoryUrlModel.setBrandIdFk(id);
            accessoryUrlModel.setCreatedTime(new Date());
            accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
            accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ELEVEN);
        }
        brandDao.addAccessoryList(invoiceList);
        return id;
    }

    /**
     * 带条件分页查询
     * @param brandModel
     * @return
     */
    @Override
    public ResponseDTO selectAptitudeList(BrandModel brandModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        Integer pageIndex = (brandModel.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(brandModel.getPageSize());
        brandModel.setPageIndex(pageIndex);
        List<BrandModel> brandModelList = brandDao.selectAptitudeList(brandModel);
        if (!brandModelList.isEmpty()) {
            responseDTO.setData(brandModelList);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        Integer count = brandDao.selectAptitudeListCount(brandModel);
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
    public BrandResponseDTO getAptitudeById(Integer id) {
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

}
