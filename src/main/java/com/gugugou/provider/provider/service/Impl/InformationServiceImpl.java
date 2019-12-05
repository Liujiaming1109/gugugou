package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.model.InformationContact;
import com.gugugou.provider.provider.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationDao informationDao;

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
}
