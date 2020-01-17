package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.SettlementLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
}
