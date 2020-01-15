package com.gugugou.provider.provider.service;

import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.provider.model.*;

import java.util.List;
import java.util.Map;

public interface InformationService {

    /**添加供应商的基本信息*/
    Long addInformation(Information information);

    /**计算供应商下一次结算时间*/


    /**查看供应商基本信息*/
    Information findInformationById(Long id);

    /**修改供应商的基本信息*/
    int updateInformation(Information information);

    /**修改供应商的供应状态*/
    int updateInformationStatus(Information information);

    /**查看详情*/
    Map selectDetalById(Long id);

    /**修改采销负责人*/
    int updateContactName(InformationContact informationContact);

    /**查看供应商列表带条件*/
    Map findAllProviders(QueryField queryField);

    /**查找所有供应商[给商品模块提供所有供应商绑定]*/
    List<Information> queryAllProviders();

    /**供应商管理----编辑品牌资质*/
    List<BrandModel> updatedBrandAptitu(long ids);
}
