package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuelitao
 * @date 2019/12/12 18:30
 */
@RestController
@RequestMapping("settlement")
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    /**
     * 新增结算单
     * @param settlement
     * @return
     */
    @RequestMapping("sell/addSettlement")
    public Integer addSettlement(@RequestBody Settlement settlement){

        return settlementService.addSettlement(settlement);
    }

    /**
     * 根据id查询结算单
     * @param id
     * @return
     */
    @RequestMapping("sell/getSettlementById")
    public Settlement getSettlementById(@RequestParam Long id){

        return settlementService.getSettlementById(id);
    }
}
