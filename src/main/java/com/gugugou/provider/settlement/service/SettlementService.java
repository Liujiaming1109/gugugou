package com.gugugou.provider.settlement.service;

import com.gugugou.provider.settlement.model.Settlement;

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
     * 根据id查询处罚单
     * @param id
     * @return
     */
    Settlement getSettlementById(Long id);
}
