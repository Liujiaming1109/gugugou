package com.gugugou.provider.provider.dao;

import com.gugugou.provider.provider.model.Aptitude;
import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.model.InformationContact;
import com.gugugou.provider.provider.model.QueryField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface InformationDao {

    /**添加供应商的基本信息*/
    int addInformation(Information information);
    /**添加供应商的联系人*/
    int addInformationContact(InformationContact contacts);
    /**查看供应商的基本信息*/
    Information findInformationById(int id);
    /**修改供应商的基本信息*/
    int updateInformation(Information information);
    /**修改供应商的联系人*/
    int updateInformationContact(InformationContact informationContact);
    /**修改供应商经营状态*/
    int updateInformationStatus(Information information);
    /**修改平台负责人*/
    int updateContactName(InformationContact informationContact);
    /**查找所有的供应商*/
    List<QueryField> findAllProviders(QueryField queryField);
    /**根据条件查找供应商的总数*/
    Integer findAllProvidersCount(QueryField queryField);
    /**查找所有供应商*/
    List<Information> findAllProvider();

}
