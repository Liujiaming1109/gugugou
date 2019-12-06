package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.provider.dao.AptitudeDao;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.dao.ProviderDao;
import com.gugugou.provider.provider.model.Aptitude;
import com.gugugou.provider.provider.model.Finance;
import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.model.InformationContact;
import com.gugugou.provider.provider.service.AptitudeService;
import com.gugugou.provider.provider.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {
    /**供应商基本信息*/
    @Resource
    private InformationDao informationDao;
    /**供应商的财务信息*/
    @Resource
    private ProviderDao providerDao;
    /**供应商的资质信息*/
    @Resource
    private AptitudeDao aptitudeDao;

    @Action

    /**添加供应商的基本信息*/
    @Override
    public int addInformation(Information information) {
        int count = informationDao.addInformation(information);
        List<InformationContact> informationContacts = information.getInformationContacts();
        for (InformationContact contacts : informationContacts) {
            informationDao.addInformationContact(contacts);
        }

        return count;
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
}
