package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.settlement.dao.SettlementDao;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:49
 */
@Service
public class SettlementServiceImpl implements SettlementService {

    @Resource
    private SettlementDao settlementDao;

    /**
     * 新增结算单
     * @param settlement
     * @return
     */
    @Override
    public Integer addSettlement(Settlement settlement) {
        //这里要设置汇总金额
        //获取订单集合，合并同类项，计算汇总金额

        return settlementDao.addSettlement(settlement);
    }

    /**
     * 根据id查询结算单
     * @param id
     * @return
     */
    @Override
    public Settlement getSettlementById(Long id) {

        return settlementDao.getSettlementById(id);
    }
}
