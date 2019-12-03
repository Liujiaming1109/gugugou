package com.gugugou.provider.provider.controller;

import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.service.InformationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("provider")
@RestController
public class InformationController {

     @Resource
     private InformationService informationService;

     @PostMapping("base/addbase")
     public int addInformation(@RequestBody Information information){
         return informationService.addInformation(information);
     }
}
