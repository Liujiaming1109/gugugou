package com.gugugou.provider.violations.controller;

import com.gugugou.provider.violations.model.Violations;
import com.gugugou.provider.violations.service.ViolationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 违规处罚
 */
@RequestMapping("violations")
@RestController
public class ViolationsController {

    @Autowired
    public ViolationsService violationsService;

    /**
     * 查询单条违规处罚单
     * @param id
     * @return
     */
    @GetMapping("ticket/getTicketById")
    public Violations getTicketById(@RequestParam Integer id){
        Violations violations = violationsService.getTicketById(id);
        return violations;
    }

    /**
     * 新增违规处罚单
     * @param violations
     * @return
     */
    @PostMapping("ticket/addTicket")
    public Integer addTicket(@RequestBody Violations violations){

        return violationsService.addTicket(violations);
    }

    /**
     * 修改违规处罚单
     * @param violations
     * @return
     */
    @PostMapping("ticket/updateTicket")
    public Integer updateTicket(@RequestBody Violations violations){

        return violationsService.updateTicket(violations);
    }
}
