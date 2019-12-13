package com.gugugou.provider.provider.service;

import com.gugugou.provider.provider.model.*;

import java.util.List;
import java.util.Map;

public interface InformationService {

    /**添加供应商的基本信息*/
    Long addInformation(Information information);
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
    /**查看供应商列表*/
    Map findAllProviders(QueryField queryField);
}
