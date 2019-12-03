package com.gugugou.provider.provider.controller;



import com.gugugou.provider.provider.model.Models;
import com.gugugou.provider.provider.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: chengShaoShao
 * @Title: ProviderController
 * @ProjectName: provider
 * @Description:
 * @date 2019/11/26 14:27
 */
@RequestMapping("provider")
@RestController
public class ProviderController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProviderService providerService;


    //新增财务信息
   @PostMapping("addProvider")
    public Long addProvider(@RequestBody Models models){
         return providerService.addProvider(models);
    }

    //修改财务信息
    @PostMapping("updateProvider")
    public Long updateProvider(@RequestBody Models models){
        return providerService.updateProvider(models);
    }

}
