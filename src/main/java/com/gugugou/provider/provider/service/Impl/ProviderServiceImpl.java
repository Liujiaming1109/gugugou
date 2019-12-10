package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.dao.ProviderDao;

import com.gugugou.provider.provider.model.Finance;
import com.gugugou.provider.provider.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: ProviderServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 14:22
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private ProviderDao providerDao;
    @Resource
    private InformationDao informationDao;


   //添加财务信息
    @Override
    public int addProvider(Finance models) {
        return providerDao.addProvider(models);
    }


    //修改财务信息
    @Override
    public int updateProvider(Finance models) {
        return providerDao.updateProvider(models);
    }

    //查找财务信息
    @Override
    public Finance findProvider(int fk) {
        return providerDao.findProvider(fk);
    }

}
