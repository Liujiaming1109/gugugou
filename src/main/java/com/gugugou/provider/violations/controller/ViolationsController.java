package com.gugugou.provider.violations.controller;

import com.gugugou.provider.violations.model.Violations;
import com.gugugou.provider.violations.service.ViolationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("violations")
@RestController
public class ViolationsController {

    @Autowired
    public ViolationsService violationsService;

    @GetMapping("ticket/getTicketById")
    @ResponseBody
    public Violations getTicketById(@RequestParam Integer id){
        Violations violations = violationsService.getTicketById(id);
        return violations;
    }
}
