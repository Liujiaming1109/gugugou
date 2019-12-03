package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.provider.dao.ProviderDao;

import com.gugugou.provider.provider.model.Models;
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



    @Override
    public Long addProvider(Models models) {
        return providerDao.addProvider(models);
    }


    //修改财务信息
    @Override
    public Long updateProvider(Models models) {
        return providerDao.updateProvider(models);
    }

}
