package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.SettlementManage;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:47
 */
public interface SettlementManageService {
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
    ResponseDTO selectSettlementManageList(SettlementManage settlementManage);

}
