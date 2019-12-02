package com.gugugou.provider.provider.service;


import com.gugugou.provider.provider.model.Models;

/**
 * @author: chengShaoShao
 * @Title: ProviderService
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 14:21
 */
public interface ProviderService {

    //新增财务信息
    Long addProvider(Models models);

   //修改财务信息
    Long updateProvider(Models models);

    //查找财务信息
   /* Models findProvider(Integer tProviderFk);*/
}
