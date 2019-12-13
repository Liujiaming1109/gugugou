package com.gugugou.provider.provider.service;

import com.gugugou.provider.provider.model.Aptitude;

import java.util.Map;

public interface AptitudeService {
    /**增加供应商资质信息*/
    Integer addProviderAptitude(Aptitude aptitude);
    /**修改供应商资质信息*/
    Integer updateProviderAptitude(Aptitude aptitude);
    /**查看供应商的资质信息*/
    Map findAptitudeById(Long providerIdFk);
}
