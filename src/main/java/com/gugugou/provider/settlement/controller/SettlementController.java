package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.service.SettlementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author: yuelitao
 * @date 2019/12/12 18:30
 */
@RestController
@RequestMapping("settlement")
public class SettlementController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SettlementService settlementService;

    /**
     * 新增结算单
     * @param settlement
     * @return
     */
    @RequestMapping("sell/addSettlement")
    public Integer addSettlement(@RequestBody Settlement settlement){
        logger.info("新增结算单的入参--settlement : {}",settlement);
        return settlementService.addSettlement(settlement);
    }

    /**
     * 根据id查询结算单
     * @param id
     * @return
     */
    @GetMapping("sell/getSettlementById")
    public Settlement getSettlementById(@RequestParam Long id){
        logger.info("查询结算单的入参--id : {}",id);
        return settlementService.getSettlementById(id);
    }

    /**
     * 根据结算单id更新结算单状态
     * @param settlement
     * @return
     */
    @PostMapping("sell/updateSettlementStatusById")
    public Integer updateSettlementStatusById(@RequestBody Settlement settlement){
        logger.info("更新结算单的入参--settlement : {}",settlement);
        return settlementService.updateSettlementStatusById(settlement);
    }

    /**
     * 分页查询结算单列表(结算单管理页面(不包含结算单行数据))
     * @param settlement
     * @return
     */
    @PostMapping("sell/selectSettlementList")
    public ResponseDTO selectSettlementList(@RequestBody Settlement settlement){
        logger.info("查询结算单列表的入参--settlement : {}",settlement);
        return settlementService.selectSettlementList(settlement);
    }


    /**
     * 查询结算单列表（财务分账页面(包含结算单行数据)）
     * @param settlement
     * @return
     */
    @PostMapping("sell/selectSettlementListForFinance")
    public ResponseDTO selectSettlementListForFinance(@RequestBody Settlement settlement){
        logger.info("查询结算单列表的入参（含购结算单行数据）--settlement : {}",settlement);
        return settlementService.selectSettlementListForFinance(settlement);
    }
}
