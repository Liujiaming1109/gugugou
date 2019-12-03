package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationDao informationDao;

    @Override
    public int addInformation(Information information) {
        informationDao.addInformation(information);
        return informationDao.addInformations(information);
    }
}
