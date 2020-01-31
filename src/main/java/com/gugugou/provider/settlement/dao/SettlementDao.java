package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.FinanceRouting;
import com.gugugou.provider.settlement.model.Settlement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:44
 */
@Mapper
public interface SettlementDao {
    /**
     * 新增一个结算单
     * @param settlement
     * @return
     */
    Integer addSettlement(Settlement settlement);

    /**
     * 根据id查询结算单
     * @param id
     * @return
     */
    Settlement getSettlementById(@Param("id") Long id);

    /**
     * 根据结算单id更新结算单状态
     * @param settlement
     * @return
     */
    Integer updateSettlementStatusById(Settlement settlement);

    /**
     * 查询结算单管理列表
     * @param settlement
     * @return
     */
    List<Settlement> selectSettlementList(Settlement settlement);

    /**
     * 查询结算单管理表的记录数
     * @param settlement
     * @return
     */
    Integer selectSettlementCount(Settlement settlement);

    /**
     * 根据id查询结算单列表
     */
    List<Settlement> findSettlementListById(@Param("idSet") Set<Long> idSet);

    /**
     * 根据结算单行id查询该数据
     * @param idSet
     * @return
     */
    List<FinanceRouting> selectFinancialCollectingById(@Param("idSet") Set<Long> idSet);
}
