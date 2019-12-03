package com.gugugou.provider.provider.controller;



import com.gugugou.provider.provider.model.Finance;
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
   @PostMapping("finance/addFinance")
    public int addProvider(@RequestBody Finance models){
         return providerService.addProvider(models);
    }

    //修改财务信息
    @PostMapping("/finance/updateFinance")
    public int updateProvider(@RequestBody Finance models){
        return providerService.updateProvider(models);
    }

    //查找财务信息
    @GetMapping("finance/getFinanceById")
    public Finance findProvider(@RequestParam int fk){
       return  providerService.findProvider(fk);
    }


}
