package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.provider.dao.AptitudeDao;
import com.gugugou.provider.provider.service.AptitudeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AptitudeServiceImpl implements AptitudeService {

    @Resource
    private AptitudeDao aptitudeDao;
}
