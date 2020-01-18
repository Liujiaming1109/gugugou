package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.FinanceRouting;
import com.gugugou.provider.settlement.model.FinancialCollectingExcel;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.model.SettlementLine;
import com.gugugou.provider.settlement.service.SettlementService;
import com.wuwenze.poi.ExcelKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;


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
     * 根据结算单id查询结算单行数据
     * @param id
     * @return
     */
    @GetMapping("sell/getSettlementById")
    public List<SettlementLine> getSettlementById(@RequestParam Long id){
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
     * 结算单管理页面列表查询
     * @param settlement
     * @return
     */
    @PostMapping("sell/selectSettlementList")
    public ResponseDTO selectSettlementList(@RequestBody Settlement settlement){
        logger.info("查询结算单列表的入参--settlement : {}",settlement);
        return settlementService.selectSettlementList(settlement);
    }


    /**
     * 财务分账页面列表查询
     * @param financeRouting
     * @return
     */
    @PostMapping("sell/selectFinanceRoutingList")
    public ResponseDTO selectFinanceRoutingList(@RequestBody FinanceRouting financeRouting){
        logger.info("查询结算单列表的入参（含购结算单行数据）--financeRouting : {}",financeRouting);
        return settlementService.selectFinanceRoutingList(financeRouting);
    }

    /**
     * 根据id导出结算单列表
     * @param idSet
     * @return
     */
    @GetMapping("findSettlementListById/excel")
    public void findSettlementListById(@RequestParam("idSet") Set<Long> idSet, HttpServletResponse response) {
        logger.info("根据id导出结算单列表的入参--idsSet：{}", idSet);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Settlement> settlementListById = settlementService.findSettlementListById(idSet);
        if (!settlementListById.isEmpty()) {
            for (Settlement settlement:settlementListById) {
                String format = formatter.format(settlement.getSettlementTime());
                settlement.setSettlementTimeExcel(format);
                if (0==settlement.getSettlementStatus()) {
                    settlement.setSettlementStatusExcel("未结算");
                }else {
                    settlement.setSettlementStatusExcel("已结算");
                }
                if (0==settlement.getSettlementCycle()) {
                    settlement.setSettlementCycleExcel("日");
                }else if (1==settlement.getSettlementCycle()) {
                    settlement.setSettlementCycleExcel("周");
                }else if (2==settlement.getSettlementCycle()) {
                    settlement.setSettlementCycleExcel("双周");
                }else if (3==settlement.getSettlementCycle()) {
                    settlement.setSettlementCycleExcel("月");
                }else if (4==settlement.getSettlementCycle()) {
                    settlement.setSettlementCycleExcel("年");
                }
            }
        }
        ExcelKit.$Export(Settlement.class, response).downXlsx(settlementListById, false);
    }

    /**
     * 根据id导出结算单行数据
     * @param idSet
     * @param response
     */
    @GetMapping("findSettlementLineByIds/excel")
    public void findSettlementLineByIds(@RequestParam("idSet") Set<Long> idSet, HttpServletResponse response) {
        logger.info("根据id导出结算单行数据的入参--idSet：{}", idSet);
        List<SettlementLine> settlementLineByIds = settlementService.findSettlementLineByIds(idSet);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!settlementLineByIds.isEmpty()) {
            for (SettlementLine settlementLine:settlementLineByIds) {
                String format = formatter.format(settlementLine.getOrderPaymentTime());
                settlementLine.setOrderPaymentTimeExcel(format);
                String format1 = formatter.format(settlementLine.getOrderSuccessfulTime());
                settlementLine.setOrderSuccessfulTimeExcel(format1);
            }
        }
        ExcelKit.$Export(SettlementLine.class, response).downXlsx(settlementLineByIds, false);
    }

    /**
     * 根据结算单行id导出财务分账信息
     * @param idSet
     * @param response
     */
    @GetMapping("selectFinancialCollectingById/excel")
    public void selectFinancialCollectingById(@RequestParam("idSet") Set<Long> idSet, HttpServletResponse response) {
        logger.info("根据结算单行id导出财务分账信息的入参--idSet：{}", idSet);
        List<FinancialCollectingExcel> financialCollectingExcelList = settlementService.selectFinancialCollectingById(idSet);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!financialCollectingExcelList.isEmpty()) {
            for (FinancialCollectingExcel financialCollectingExcel:financialCollectingExcelList) {
                String format = formatter.format(financialCollectingExcel.getOrderPaymentTime());
                financialCollectingExcel.setOrderPaymentTimeExcel(format);
                String format1 = formatter.format(financialCollectingExcel.getOrderSuccessfulTime());
                financialCollectingExcel.setOrderSuccessfulTimeExcel(format1);
                if (0==financialCollectingExcel.getSettlementStatus()) {
                    financialCollectingExcel.setSettlementStatusExcel("未结算");
                }else {
                    financialCollectingExcel.setSettlementStatusExcel("已结算");
                }
            }
        }
        ExcelKit.$Export(FinancialCollectingExcel.class, response).downXlsx(financialCollectingExcelList, false);
    }
}
