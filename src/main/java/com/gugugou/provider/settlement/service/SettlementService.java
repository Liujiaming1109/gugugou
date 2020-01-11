package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
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

    /**
     * 根据结算单id更新结算单状态
     * @param settlement
     * @return
     */
    Integer updateSettlementStatusById(Settlement settlement);

    /**
     * 查询结算单列表（不包含结算单行数据）
     * @param settlement
     * @return
     */
    ResponseDTO selectSettlementList(Settlement settlement);

    /**
     * 查询结算单列表（包含结算单行数据）
     * @param settlement
     * @return
     */
    ResponseDTO selectSettlementListForFinance(Settlement settlement);
}
