package com.gugugou.provider.violations.controller;

import com.gugugou.provider.violations.dto.ViolationsResponseDTO;
import com.gugugou.provider.violations.model.Violations;
import com.gugugou.provider.violations.service.ViolationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 违规处罚
 */
@RequestMapping("violations")
@RestController
public class ViolationsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ViolationsService violationsService;

    /**
     * 查询单条违规处罚单
     * @param id
     * @return
     */
    @GetMapping("ticket/getTicketById")
    public ViolationsResponseDTO getTicketById(@RequestParam Integer id){
        logger.info("查询单条违规处罚单的入参：{}",id);

        return violationsService.getTicketById(id);
    }

    /**
     * 新增违规处罚单
     * @param violations
     * @return
     */
    @PostMapping("ticket/addTicket")
    public Integer addTicket(@RequestBody Violations violations){
        logger.info("新增违规处罚的入参：{}",violations);
        return violationsService.addTicket(violations);
    }

    /**
     * 修改违规处罚单
     * @param violations
     * @return
     */
    @PostMapping("ticket/updateTicket")
    public Integer updateTicket(@RequestBody Violations violations){
        logger.info("修改违规处罚的入参：{}",violations);
        return violationsService.updateTicket(violations);
    }
}
