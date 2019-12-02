package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.provider.dao.ProviderDao;
import com.gugugou.provider.provider.model.ProviderModel;
import com.gugugou.provider.provider.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
    public Long addProvider(ProviderModel providerModel) {
        providerModel.setCreatedBy("程绍绍");
        providerModel.setCreatedTime(new Date());
        providerModel.setRemoved(ProviderCentreConsts.REVISION_ZERO);
        return providerDao.addProvider(providerModel);
    }
}
