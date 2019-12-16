package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.SettlementManage;
import com.gugugou.provider.settlement.service.SettlementManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuelitao
 * @date 2019/12/13 16:43
 */
@RestController
@RequestMapping("settlement")
public class SettlementManageController {

    @Autowired
    private SettlementManageService settlementManageService;

    /**
     * 新增结算单管理
     * @param settlementManage
     * @return
     */
    @PostMapping("sell/addSettlementManage")
    public Integer addSettlementManage(@RequestBody SettlementManage settlementManage){

        return settlementManageService.addSettlementManage(settlementManage);
    }

    /**
     * 分页查询结算单管理列表
     * @param settlementManage
     * @return
     */
    @PostMapping("sell/selectSettlementManageList")
    public ResponseDTO selectSettlementManageList(@RequestBody SettlementManage settlementManage){

        return settlementManageService.selectSettlementManageList(settlementManage);
    }
}
