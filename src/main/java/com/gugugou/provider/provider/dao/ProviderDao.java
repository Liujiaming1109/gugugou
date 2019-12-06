package com.gugugou.provider.provider.dao;


import com.gugugou.provider.provider.model.Finance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    int addProvider(Finance models);

   //修改财务信息
    int updateProvider(Finance models);

   //查找财务信息
    Finance findProvider(int fk);

    //查找财务信息根据参数id
    Finance selectBaseInfoByinformationId(int id);
}
