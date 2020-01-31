package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.FinanceRouting;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.model.SettlementLine;

import java.util.List;
import java.util.Set;

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

    /**
     * 根据id导出结算单列表
     */
    List<Settlement> findSettlementListById(Set<Long> idSet);

    /**
     * 根据id导出结算单行数据
     * @param idSet
     * @return
     */
    List<SettlementLine> findSettlementLineByIds(Set<Long> idSet);

    /**
     * 根据结算单行id导出财务分账信息
     * @param idSet
     * @return
     */
    List<FinanceRouting> selectFinancialCollectingById(Set<Long> idSet);
}
