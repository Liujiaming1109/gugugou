package com.gugugou.provider.provider.service;

import com.gugugou.provider.provider.model.Aptitude;

public interface AptitudeService {
    /**增加供应商资质信息*/
    Integer addProviderAptitude(Aptitude aptitude);
    /**修改供应商资质信息*/
    Integer updateProviderAptitude(Aptitude aptitude);
}
