package com.gugugou.provider.provider.controller;


import com.gugugou.provider.provider.model.ProviderModel;
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

    @PostMapping("addProvider")
    public Integer addProvider(@RequestBody ProviderModel providerModel) {
        logger.info("新增---providerModel: {}", providerModel);
        return providerService.addProvider(providerModel);
    }

}
