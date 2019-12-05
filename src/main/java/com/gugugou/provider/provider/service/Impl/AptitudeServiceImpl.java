package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.provider.dao.AptitudeDao;
import com.gugugou.provider.provider.model.Aptitude;
import com.gugugou.provider.provider.service.AptitudeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AptitudeServiceImpl implements AptitudeService {

    @Resource
    private AptitudeDao aptitudeDao;

    /**
     * 添加供应商的资质信息
     */
    @Override
    public Integer addProviderAptitude(Aptitude aptitude) {
        aptitude.setCreatedTime(new Date());
        aptitude.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
        aptitudeDao.addProviderAptitude(aptitude);
        Integer id = aptitude.getId();
        List<AccessoryUrlModel> taxRegistration = aptitude.getTaxRegistration();
        if (!taxRegistration.isEmpty()) {
            for (AccessoryUrlModel tax : taxRegistration) {
                tax.setBrandIdFk(id);
                tax.setCreatedTime(new Date());
                tax.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                tax.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                tax.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
            }
            aptitudeDao.addProviderAptitudeUrl(taxRegistration);
        }

        List<AccessoryUrlModel> businessAccessory = aptitude.getBusinessAccessory();
         if(!businessAccessory.isEmpty()){
             for (AccessoryUrlModel  business : businessAccessory) {
                 business.setBrandIdFk(id);
                 business.setCreatedTime(new Date());
                 business.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 business.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                 business.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
             }
             aptitudeDao.addProviderAptitudeUrl(businessAccessory);
         }
        List<AccessoryUrlModel> taxPayerAccessory = aptitude.getTaxPayerAccessory();
         if(!taxPayerAccessory.isEmpty()){
             for (AccessoryUrlModel payer: taxPayerAccessory) {
                 payer.setBrandIdFk(id);
                 payer.setCreatedTime(new Date());
                 payer.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 payer.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                 payer.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
             }
             aptitudeDao.addProviderAptitudeUrl(taxPayerAccessory);
         }
        List<AccessoryUrlModel> bankAccessory = aptitude.getBankAccessory();
         if(!bankAccessory.isEmpty()){
             for (AccessoryUrlModel bank: bankAccessory) {
                 bank.setBrandIdFk(id);
                 bank.setCreatedTime(new Date());
                 bank.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 bank.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                 bank.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
             }
             aptitudeDao.addProviderAptitudeUrl(bankAccessory);
         }
        List<AccessoryUrlModel> representativeAccessory = aptitude.getRepresentativeAccessory();
         if(!representativeAccessory.isEmpty()){
             for (AccessoryUrlModel represent : representativeAccessory) {
                 represent.setBrandIdFk(id);
                 represent.setCreatedTime(new Date());
                 represent.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 represent.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ONE);
                 represent.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
             }
             aptitudeDao.addProviderAptitudeUrl(representativeAccessory);
         }

        return id;
    }


        /**修改供应商的资质信息*/
        @Override
        public Integer updateProviderAptitude (Aptitude aptitude){
            aptitude.setUpdatedTime(new Date());
            int aptitude1 = aptitudeDao.updateProviderAptitude(aptitude);
            List<AccessoryUrlModel> taxRegistration = aptitude.getTaxRegistration();
            if(!taxRegistration.isEmpty()){
                for (AccessoryUrlModel accessoryUrlModel: taxRegistration) {
                    accessoryUrlModel.setUpdatedTime(new Date());
                    aptitudeDao.updateProviderAptitudeUrl(taxRegistration);
                }
            }
            List<AccessoryUrlModel> businessAccessory = aptitude.getBusinessAccessory();
            if(!businessAccessory.isEmpty()){
                for (AccessoryUrlModel business :businessAccessory) {
                    business.setUpdatedTime(new Date());
                    aptitudeDao.updateProviderAptitudeUrl(businessAccessory);
                }
            }
            List<AccessoryUrlModel> taxPayerAccessory = aptitude.getTaxPayerAccessory();
            if(!taxPayerAccessory.isEmpty()){
                for (AccessoryUrlModel payer :taxPayerAccessory) {
                    payer.setUpdatedTime(new Date());
                    aptitudeDao.updateProviderAptitudeUrl(taxPayerAccessory);
                }
            }
            List<AccessoryUrlModel> bankAccessory = aptitude.getBankAccessory();
            if(!bankAccessory.isEmpty()){
                for (AccessoryUrlModel banks :bankAccessory) {
                    banks.setUpdatedTime(new Date());
                    aptitudeDao.updateProviderAptitudeUrl(bankAccessory);
                }
            }
            List<AccessoryUrlModel> representativeAccessory = aptitude.getRepresentativeAccessory();
            if(!representativeAccessory.isEmpty()){
                for (AccessoryUrlModel represent :representativeAccessory) {
                    represent.setUpdatedTime(new Date());
                    aptitudeDao.updateProviderAptitudeUrl(representativeAccessory);
                }
            }

            return aptitude1;
        }
    }

