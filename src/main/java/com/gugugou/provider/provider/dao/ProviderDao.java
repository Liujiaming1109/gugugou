package com.gugugou.provider.provider.dao;

import com.gugugou.provider.provider.model.ProviderModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: chengShaoShao
 * @Title: ProviderDap
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 14:18
 */
@Mapper
public interface ProviderDao {

    Long addProvider(ProviderModel providerModel);
}
