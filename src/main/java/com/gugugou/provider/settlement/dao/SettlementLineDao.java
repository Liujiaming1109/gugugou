package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.FinanceRouting;
import com.gugugou.provider.settlement.model.SettlementLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2020/1/9 15:00
 */
@Mapper
public interface SettlementLineDao {

    /**
     * 根据settlementId获取结算单行集合
     * @param settlementId
     * @return
     */
    List<SettlementLine> selectSettlementLinesBySettlementId(Long settlementId);

    /**
     * 批量新增结算单行数据
     * @param settlementLines
     * @return
     */
    Integer addSettlementLines(List<SettlementLine> settlementLines);

    /**
     * 查询财务分账列表
     * @param financeRouting
     * @return
     */
    List<FinanceRouting> selectFinanceRoutingList(FinanceRouting financeRouting);

    /**
     * 根据财务分账列表查询条件，获取结算单行记录数
     * @param financeRouting
     * @return
     */
    Integer selectSettlementLineCount(FinanceRouting financeRouting);

    /**
     * 根据id查询结算单行数据
     * @param idSet
     * @return
     */
    List<SettlementLine> findSettlementLineByIds(@Param("idSet") Set<Long> idSet);
}
