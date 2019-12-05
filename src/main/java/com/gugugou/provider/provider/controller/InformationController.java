package com.gugugou.provider.provider.controller;

import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.service.InformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("provider")
@RestController
public class InformationController {

    @Resource
    private InformationService informationService;

    /**
     * 添加供应商的基本信息
     */
    @PostMapping("base/addbase")
    public int addInformation(@RequestBody Information information) {
        return informationService.addInformation(information);
    }

    /**
     * 查看供应商的基本信息
     */
    @GetMapping("base/findById")
    public Information findInformation(@RequestParam int id) {
        Information informationById = informationService.findInformationById(id);
        return informationById;
    }

    /**修改供应商的基本信息*/
    @PostMapping("base/updatebase")
    public int updateInformation(@RequestBody Information information){
           return informationService.updateInformation(information);
    }

    /**修改供应商的经营状态和原因*/
    @PostMapping("base/updateManageStutas")
    public int updateInformationStatus(@RequestBody Information information){
            return informationService.updateInformationStatus(information);
    }
}