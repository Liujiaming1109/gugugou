package com.gugugou.provider.aptitude.service.Impl;

import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.aptitude.service.BrandService;
import com.gugugou.provider.common.ProviderCentreConsts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: BrandServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 15:36
 */
@Service
public class BrandServiceImpl implements BrandService {

   @Resource
   private BrandDao aptitudeDao;

    /**
     * 新增品牌资质
     * @param brandModel
     * @return
     */
    @Override
    public Long addBrand(BrandModel brandModel) {
        brandModel.setCreatedTime(new Date());
        brandModel.setRemoved(ProviderCentreConsts.REVISION_ZERO);
        return aptitudeDao.addBrand(brandModel);
    }
}
