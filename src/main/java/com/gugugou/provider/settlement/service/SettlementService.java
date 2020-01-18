package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.FinanceRouting;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.model.SettlementLine;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:46
 */
public interface SettlementService {
    /**
     * 新增一个结算单
     * @param settlement
     * @return
     */
    Integer addSettlement(Settlement settlement);

    /**
     * 根据结算单id查询结算单详情
     * @param id
     * @return
     */
    List<SettlementLine> getSettlementById(Long id);

    /**
     * 根据结算单id更新结算单状态
     * @param settlement
     * @return
     */
    Integer updateSettlementStatusById(Settlement settlement);

    /**
     * 查询结算单列表
     * @param settlement
     * @return
     */
    ResponseDTO selectSettlementList(Settlement settlement);

    /**
     * 查询财务分账列表
     * @param financeRouting
     * @return
     */
    ResponseDTO selectFinanceRoutingList(FinanceRouting financeRouting);
}
