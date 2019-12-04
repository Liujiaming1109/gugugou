package com.gugugou.provider.provider.controller;

import com.gugugou.provider.provider.service.AptitudeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("provider")
@RestController
public class AptitudeController {

    @Resource
    private AptitudeService aptitudeService;
}
