package com.gugugou.provider.provider.service;


import com.gugugou.provider.provider.model.Finance;

/**
 * @author: chengShaoShao
 * @Title: ProviderService
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 14:21
 */
public interface ProviderService {

    //新增财务信息
    int addProvider(Finance models);

   //修改财务信息
    int updateProvider(Finance models);

    //查找财务信息
    Finance findProvider(int fk);

}
