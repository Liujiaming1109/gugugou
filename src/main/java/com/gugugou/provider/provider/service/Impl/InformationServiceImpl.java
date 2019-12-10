package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.provider.dao.AptitudeDao;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.dao.ProviderDao;
import com.gugugou.provider.provider.model.*;
import com.gugugou.provider.provider.service.AptitudeService;
import com.gugugou.provider.provider.service.InformationService;
import com.gugugou.provider.provider.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {
    /**供应商基本信息*/
    @Resource
    private InformationDao informationDao;
    /**资质表业务层*/
    private AptitudeService aptitudeService;
    /**财务信息业务层*/
    private ProviderService providerService;
    /**资质信息的dao层*/
    private AptitudeDao aptitudeDao;
    /**财务信息dao层*/
    private ProviderDao providerDao;

    /**添加供应商的基本信息*/
    @Override
    public int addInformation(Information information) {
        informationDao.addInformation(information);
        /**获取供应商主键id*/
        int id = information.getId();
       /**添加供应商的基本信息*/
       informationDao.addInformation(information);
        List<InformationContact> informationContacts = information.getInformationContacts();
        for (InformationContact contacts : informationContacts) {
            informationDao.addInformationContact(contacts);
        }

        return id;
    }
    /**返现供应商的基本信息*/
    @Override
    public Information findInformationById(int id) {

        return informationDao.findInformationById(id);
    }
    /**修改供应商的基本信息*/
    @Override
    public int updateInformation(Information information) {
        int count = informationDao.updateInformation(information);
        List<InformationContact> informationContacts = information.getInformationContacts();
        for (InformationContact contacts : informationContacts) {
             informationDao.updateInformationContact(contacts);
        }
        return count;
    }
    /**修改供应商的经营状态*/
    @Override
    public int updateInformationStatus(Information information) {
        return informationDao.updateInformationStatus(information);
    }

    @Override
    public Map selectDetalById(int id) {
        //第一步  查询供应商基本信息表
        Information informationById = informationDao.findInformationById(id);

        //第二步  查询资质信息
        Aptitude aptitude = aptitudeDao.selectAptitude(id);
        AccessoryUrlModel accessoryUrlModel = new AccessoryUrlModel();
        accessoryUrlModel.setProviderAptitudeIdFk(aptitude.getProviderIdFk());

        /**企业资质执照附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_ZERO);
        List<AccessoryUrlModel> taxRegistration = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxRegistration(taxRegistration);
        /**税务登记表附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_ONE);
        List<AccessoryUrlModel> enterpriseAptitudes = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setEnterpriseAptitude(enterpriseAptitudes);
        /**组织机构附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_TWO);
        List<AccessoryUrlModel> businessAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(businessAccessory);
        /**一般纳税人附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_THREE);
        List<AccessoryUrlModel> taxPayerAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(taxPayerAccessory);
        /**银行开户附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_FOUR);
        List<AccessoryUrlModel> bankAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(bankAccessory);
        /**法定代表人身份附件*/
        accessoryUrlModel.setAccessoryName(ProviderCentreConsts.PROVIDER_ADDRESS_FIVE);
        List<AccessoryUrlModel> representativeAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(representativeAccessory);


        //第三部  查询财务信息
        Finance finance =  providerDao.selectBaseInfoByinformationId(id);
        Map<String,Object>  returnMap  = new HashMap<>();
        returnMap.put("information",informationById);
        returnMap.put("aptitude",aptitude);

        returnMap.put("finance",finance);
        return returnMap;
    }
    /**设置采销负责人*/
    @Override
    public int updateContactName(InformationContact informationContact) {
        return informationDao.updateContactName(informationContact);
    }
    /**查看供应商列表*/
    @Override
    public Map findAllProviders(QueryField queryField) {
        Map<Object, Object> returnMap = new HashMap<>();
        Integer pageIndex = (queryField.getPageIndex()-ProviderCentreConsts.INTEGER_ONE)*(queryField.getPageSize());
        queryField.setPageIndex(pageIndex);
        List<QueryField> allProviders = informationDao.findAllProviders(queryField);
        if (!allProviders.isEmpty()) {
            returnMap.put("data",allProviders);
        }else {
            returnMap.put("data",new ArrayList<>());
        }
        Integer count = informationDao.findAllProvidersCount(queryField);
        if (null != count && count > ProviderCentreConsts.INTEGER_ZERO) {
            returnMap.put("count",count);
        }
        return returnMap;
    }
}
