package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.Settlement;
import org.apache.ibatis.annotations.Mapper;

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
     * 根据id查询处罚单
     * @param id
     * @return
     */
    Settlement getSettlementById(Long id);
}
