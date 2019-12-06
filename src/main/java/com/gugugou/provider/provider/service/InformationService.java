package com.gugugou.provider.provider.service;

import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.model.InformationContact;

import java.util.Map;

public interface InformationService {

    /**添加供应商的基本信息*/
    int addInformation(Information information);
    /**查看供应商基本信息*/
    Information findInformationById(int id);
    /**修改供应商的基本信息*/
    int updateInformation(Information information);
    /**修改供应商的供应状态*/
    int updateInformationStatus(Information information);
    /**查看详情*/
    Map selectDetalById(int id);
    /**修改采销负责人*/
    int updateContactName(InformationContact informationContact);
}
