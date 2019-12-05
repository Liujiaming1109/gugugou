package com.gugugou.provider.provider.service;

import com.gugugou.provider.provider.model.Information;

public interface InformationService {

    /**添加供应商的基本信息*/
    int addInformation(Information information);
    /**查看供应商基本信息*/
    Information findInformationById(int id);
    /**修改供应商的基本信息*/
    int updateInformation(Information information);
    /**修改供应商的供应状态*/
    int updateInformationStatus(Information information);

}
