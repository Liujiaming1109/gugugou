package com.gugugou.provider.provider.controller;

import com.gugugou.provider.provider.model.Aptitude;
import com.gugugou.provider.provider.service.AptitudeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
/**
 * 供应商资质信息
 * */

@RequestMapping("provider")
@RestController
public class AptitudeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AptitudeService aptitudeService;

    /**资质信息----添加供应商资质信息*/
    @PostMapping("aptitude/addaptitude")
    public Integer addProviderAptitude(@RequestBody Aptitude aptitude){
          return aptitudeService.addProviderAptitude(aptitude);
    }

    /**资质信息----修改供应商资质信息*/
    @PostMapping("updateaptitude")
    public Integer updateProviderAptitude(@RequestBody Aptitude aptitude){
          return aptitudeService.updateProviderAptitude(aptitude);
    }

    /**资质信息----查看供应商的资质信息*/
    @GetMapping("findAptitudeById")
    public Map findAptitudeById(@RequestParam Long id){
            return aptitudeService.findAptitudeById(id);
    }

    /*@Scheduled(cron = "0/3 * * * * ?")
    public void mytasker(){
        System.out.println("==================================");
    }*/

}
