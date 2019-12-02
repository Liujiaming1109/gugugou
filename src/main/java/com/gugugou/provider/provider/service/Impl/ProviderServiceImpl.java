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

   /* @Resource
    private ProviderModel providerModel;*/

    //新增财务信息

    @Override
    public Long addProvider(Models models) {
       /* providerModel.setCreatedBy("");
        providerModel.setCreatedTime(new Date());
        providerModel.setRemoved(ProviderCentreConsts.REVISION_ZERO);*/
        return providerDao.addProvider(models);
    }


    //修改财务信息
    @Override
    public Long updateProvider(Models models) {
        return providerDao.updateProvider(models);
    }

    //查询财务信息
  /*  @Override
    public Models findProvider(Integer tProviderFk) {
        return providerDao.findProvider(tProviderFk);
    }
*/
   /* @Override
    public Long addProvider(ProviderModel providerModel) {
        providerModel.setCreatedBy("程绍绍");
        providerModel.setCreatedTime(new Date());
        providerModel.setRemoved(ProviderCentreConsts.REVISION_ZERO);
        return providerDao.addProvider(providerModel);
    }*/
}
