package com.gugugou.provider.provider.controller;

import com.gugugou.provider.provider.model.Aptitude;
import com.gugugou.provider.provider.service.AptitudeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("provider")
@RestController
public class AptitudeController {

    @Resource
    private AptitudeService aptitudeService;

    /**添加供应商资质信息*/
    @PostMapping("aptitude/addaptitude")
    public Integer addProviderAptitude(@RequestBody Aptitude aptitude){
          return aptitudeService.addProviderAptitude(aptitude);
    }

    /**修改供应商资质信息*/
    @PostMapping("updateaptitude")
    public Integer updateProviderAptitude(@RequestBody Aptitude aptitude){
          return aptitudeService.updateProviderAptitude(aptitude);
    }
}
