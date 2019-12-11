package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.provider.dao.AptitudeDao;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Aptitude;
import com.gugugou.provider.provider.service.AptitudeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AptitudeServiceImpl implements AptitudeService {

    @Resource
    private AptitudeDao aptitudeDao;
    @Resource
    private InformationDao informationDao;


    /**
     * 添加供应商的资质信息
     */
    @Override
    public Integer addProviderAptitude(Aptitude aptitude) {
        aptitude.setCreatedTime(new Date());
        aptitude.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
        aptitudeDao.addProviderAptitude(aptitude);
        List<AccessoryUrlModel> taxRegistration = aptitude.getTaxRegistration();
        if (!taxRegistration.isEmpty()) {
            for (AccessoryUrlModel tax : taxRegistration) {
                tax.setCreatedTime(new Date());
                tax.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                tax.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO);
                tax.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_ZERO);
            }
            aptitudeDao.addProviderAptitudeUrl(taxRegistration);
        }


        List<AccessoryUrlModel> enterpriseAptitude = aptitude.getEnterpriseAptitude();
        if(!enterpriseAptitude.isEmpty()){
            for (AccessoryUrlModel enterprise :enterpriseAptitude) {
                enterprise.setCreatedTime(new Date());
                enterprise.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                enterprise.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO);
                enterprise.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_ONE);
            }
            aptitudeDao.addProviderAptitudeUrl(enterpriseAptitude);
        }

        List<AccessoryUrlModel> businessAccessory = aptitude.getBusinessAccessory();
         if(!businessAccessory.isEmpty()){
             for (AccessoryUrlModel  business : businessAccessory) {
                 business.setCreatedTime(new Date());
                 business.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 business.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO);
                 business.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_TWO);
             }
             aptitudeDao.addProviderAptitudeUrl(businessAccessory);
         }
        List<AccessoryUrlModel> taxPayerAccessory = aptitude.getTaxPayerAccessory();
         if(!taxPayerAccessory.isEmpty()){
             for (AccessoryUrlModel payer: taxPayerAccessory) {
                 payer.setCreatedTime(new Date());
                 payer.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 payer.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO);
                 payer.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_THREE);
             }
             aptitudeDao.addProviderAptitudeUrl(taxPayerAccessory);
         }
        List<AccessoryUrlModel> bankAccessory = aptitude.getBankAccessory();
         if(!bankAccessory.isEmpty()){
             for (AccessoryUrlModel bank: bankAccessory) {
                 bank.setCreatedTime(new Date());
                 bank.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 bank.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO);
                 bank.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_FOUR);
             }
             aptitudeDao.addProviderAptitudeUrl(bankAccessory);
         }
        List<AccessoryUrlModel> representativeAccessory = aptitude.getRepresentativeAccessory();
         if(!representativeAccessory.isEmpty()){
             for (AccessoryUrlModel represent : representativeAccessory) {

                 represent.setCreatedTime(new Date());
                 represent.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                 represent.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_ZERO);
                 represent.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_FIVE);
             }
             aptitudeDao.addProviderAptitudeUrl(representativeAccessory);
         }

        return 1;
    }


        /**修改供应商的资质信息*/
        @Override
        public Integer updateProviderAptitude (Aptitude aptitude){
            aptitude.setUpdatedTime(new Date());
            int aptitude1 = aptitudeDao.updateProviderAptitude(aptitude);
           /* int id = aptitude.getId();
            List<AccessoryUrlModel> taxRegistration = aptitude.getTaxRegistration();
            if(!taxRegistration.isEmpty()){
                for (AccessoryUrlModel accessoryUrlModel: taxRegistration) {
                    accessoryUrlModel.setUpdatedTime(new Date());
                    accessoryUrlModel.setProviderAptitudeIdFk(id);
                    aptitudeDao.updateProviderAptitudeUrl(accessoryUrlModel);
                }
            }

            List<AccessoryUrlModel> enterpriseAptitude = aptitude.getEnterpriseAptitude();
            if(!enterpriseAptitude.isEmpty()){
                for (AccessoryUrlModel enterprise: enterpriseAptitude) {
                    enterprise.setUpdatedTime(new Date());
                    enterprise.setProviderAptitudeIdFk(id);
                    aptitudeDao.updateProviderAptitudeUrl(enterprise);
                }
            }

            List<AccessoryUrlModel> businessAccessory = aptitude.getBusinessAccessory();
            if(!businessAccessory.isEmpty()){
                for (AccessoryUrlModel business :businessAccessory) {
                    business.setUpdatedTime(new Date());
                    business.setProviderAptitudeIdFk(id);
                    aptitudeDao.updateProviderAptitudeUrl(business);
                }
            }
            List<AccessoryUrlModel> taxPayerAccessory = aptitude.getTaxPayerAccessory();
            if(!taxPayerAccessory.isEmpty()){
                for (AccessoryUrlModel payer :taxPayerAccessory) {
                    payer.setUpdatedTime(new Date());
                    payer.setProviderAptitudeIdFk(id);
                    aptitudeDao.updateProviderAptitudeUrl(payer);
                }
            }
            List<AccessoryUrlModel> bankAccessory = aptitude.getBankAccessory();
            if(!bankAccessory.isEmpty()){
                for (AccessoryUrlModel banks :bankAccessory) {
                    banks.setUpdatedTime(new Date());
                    banks.setProviderAptitudeIdFk(id);
                    aptitudeDao.updateProviderAptitudeUrl(banks);
                }
            }
            List<AccessoryUrlModel> representativeAccessory = aptitude.getRepresentativeAccessory();
            if(!representativeAccessory.isEmpty()){
                for (AccessoryUrlModel represent :representativeAccessory) {
                    represent.setUpdatedTime(new Date());
                    represent.setProviderAptitudeIdFk(id);
                    aptitudeDao.updateProviderAptitudeUrl(represent);
                }
            }
*/
            return aptitude1;
        }

    /**查看供应商资质信息*/
    @Override
    public Map findAptitudeById(int providerIdFk) {
        /**查看资质信息*/
        Aptitude aptitude = aptitudeDao.selectAptitude(providerIdFk);
        /**附件表*/
        AccessoryUrlModel accessoryUrlModel = new AccessoryUrlModel();

        int id = aptitude.getProviderIdFk();
        accessoryUrlModel.setProviderAptitudeIdFk(id);
        /**查看企业营业执照的附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_ZERO);
        List<AccessoryUrlModel> accessoryUrlModels = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxRegistration(accessoryUrlModels);
        /**查看税务登记的附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_ONE);
        List<AccessoryUrlModel> enterpriseAptitude = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxRegistration(enterpriseAptitude);
        /**查看组织资质信的附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_TWO);
        List<AccessoryUrlModel> businessAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(businessAccessory);
        /**一般纳税人资格说明附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_THREE);
        List<AccessoryUrlModel> taxPayerAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxPayerAccessory(taxPayerAccessory);
        /**银行开户附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_FOUR);
        List<AccessoryUrlModel> bankAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxPayerAccessory(bankAccessory);
        /**法定代表人身份附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_FIVE);
        List<AccessoryUrlModel> representativeAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxPayerAccessory(representativeAccessory);

        Map<String,Object>  returnMap  = new HashMap<>();
        returnMap.put("aptitude",aptitude);
        return returnMap;
    }



}

