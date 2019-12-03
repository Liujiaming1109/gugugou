package com.gugugou.provider.provider.dao;


import com.gugugou.provider.provider.model.Models;
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

    //添加财务信息
    Long addProvider(Models models);

   //修改财务信息
    Long updateProvider(Models models);
}
