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
import com.gugugou.provider.provider.service.SettlementServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**供应商基本信息中计算下次结算周期service层*/
    private SettlementServices settlementService;

    /**添加供应商的基本信息*/
    @Override
    public Long addInformation(Information information) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        /**设置供应商上一次的结算时间*/
        information.setLastSettlementTime(information.getContactStartDate());
        /**参数中包括上一次结算时间,和结算周期*/
        String nextSettleTime = settlementService.settlementTime(information);
        try {
            /**转换成Date类型*/
            Date nextTimes = df.parse(nextSettleTime);
            /**设置成供应商的下次结算时间*/
            information.setNextSettlementTime(nextTimes);
        }catch (ParseException e){
            e.printStackTrace();
        }

        /**添加供应商的基本信息*/
        informationDao.addInformation(information);
        /**获取供应商主键id*/
        Long id = information.getId();
        List<InformationContact> informationContacts = information.getInformationContacts();
        for (InformationContact contacts : informationContacts) {
            informationDao.addInformationContact(contacts);
        }

        return id;
    }

    /**返现供应商的基本信息*/
    @Override
    public Information findInformationById(Long id) {
        List<InformationContact> informationContact = informationDao.findInformationConcat(id);
        Information informationById = informationDao.findInformationById(id);
        informationById.setInformationContacts(informationContact);
        return informationById;
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

    /**供应商列表查看详情*/
    @Override
    public Map selectDetalById(Long id) {
        //第一步  查询供应商基本信息表
        Information informationById = informationDao.findInformationById(id);

        //第二步  查询资质信息
        Aptitude aptitude = aptitudeDao.selectAptitude(id);
        AccessoryUrlModel accessoryUrlModel = new AccessoryUrlModel();
        accessoryUrlModel.setProviderAptitudeIdFk(aptitude.getProviderIdFk());

        /**企业资质执照附件*/
        accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.PROVIDER_ADDRESS_ZERO);
        List<AccessoryUrlModel> taxRegistration = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setTaxRegistration(taxRegistration);
        /**税务登记表附件*/
        accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.PROVIDER_ADDRESS_ONE);
        List<AccessoryUrlModel> enterpriseAptitudes = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setEnterpriseAptitude(enterpriseAptitudes);
        /**组织机构附件*/
        accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.PROVIDER_ADDRESS_TWO);
        List<AccessoryUrlModel> businessAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(businessAccessory);
        /**一般纳税人附件*/
        accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.PROVIDER_ADDRESS_THREE);
        List<AccessoryUrlModel> taxPayerAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(taxPayerAccessory);
        /**银行开户附件*/
        accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.PROVIDER_ADDRESS_FOUR);
        List<AccessoryUrlModel> bankAccessory = aptitudeDao.selectAccessoryUrlModelList(accessoryUrlModel);
        aptitude.setBusinessAccessory(bankAccessory);
        /**法定代表人身份附件*/
        accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.PROVIDER_ADDRESS_FIVE);
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

    /**查看供应商列表带条件*/
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

    /**查询所有供应商*/
    @Override
    public List<Information> queryAllProviders() {

        return informationDao.queryAllProviders();
    }

    /**供应商管理----编辑品牌资质*/
    @Override
    public List<BrandModel> updatedBrandAptitu(long ids) {
        return informationDao.updatedBrandAptitu(ids);
    }
}
