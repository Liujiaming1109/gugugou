package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.SettlementManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:45
 */
@Mapper
public interface SettlementManageDao {

    /**
     * 新增结算单管理
     * @param settlementManage
     * @return
     */
    Integer addSettlementManage(SettlementManage settlementManage);

    /**
     * 查询结算单管理列表
     * @param settlementManage
     * @return
     */
    List<SettlementManage> selectSettlementManageList(SettlementManage settlementManage);

    /**
     * 查询结算单管理表的记录数
     * @param settlementManage
     * @return
     */
    Integer selectSettlementManageCount(SettlementManage settlementManage);
}
