package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.dao.SettlementDao;
import com.gugugou.provider.settlement.dao.SettlementLineDao;
import com.gugugou.provider.settlement.model.FinanceRouting;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.model.SettlementLine;
import com.gugugou.provider.settlement.service.SettlementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:49
 */
@Service
public class SettlementServiceImpl implements SettlementService {

    @Resource
    private SettlementDao settlementDao;

    @Resource
    private SettlementLineDao settlementLineDao;
    /**
     * 新增结算单
     * @param settlement
     * @return
     */
    @Override
    public Integer addSettlement(Settlement settlement) {
        //新增结算单，返回主键
        Integer result = settlementDao.addSettlement(settlement);
        if (result > 0){
            List<SettlementLine> settlementLines = settlement.getSettlementLines();
            if (!settlementLines.isEmpty()){
                for (SettlementLine settlementLine : settlementLines) {
                    //设置结算单行关联的结算单id
                    settlementLine.setSettlementId(settlement.getId());
                }
                //批量新增结算单行
                settlementLineDao.addSettlementLines(settlementLines);
            }
        }
        return result;
    }

    /**
     * 根据id查询结算单
     * @param id
     * @return
     */
    @Override
    public List<SettlementLine> getSettlementById(Long id) {
        //查出结算单行数据
        List<SettlementLine> settlementLines = settlementLineDao.selectSettlementLinesBySettlementId(id);
        return settlementLines;
    }

    @Override
    public Integer updateSettlementStatusById(Settlement settlement) {
        settlement.setUpdatedBy("今晚10点");
        settlement.setUpdatedTime(new Date());

        return settlementDao.updateSettlementStatusById(settlement);
    }

    @Override
    public ResponseDTO selectSettlementList(Settlement settlement) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex= (settlement.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*settlement.getPageSize();
        settlement.setPageIndex(pageIndex);
        //获取结算单列表
        List<Settlement> settlements = settlementDao.selectSettlementList(settlement);
        if (!settlements.isEmpty()){
            responseDTO.setData(settlements);
        }else {
            //如果为空，返回一个空数组
            responseDTO.setData(new ArrayList<>());
        }
        //获取结算单表记录数
        Integer count = settlementDao.selectSettlementCount(settlement);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }

        return responseDTO;
    }

    @Override
    public ResponseDTO selectFinanceRoutingList(FinanceRouting financeRouting) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex= (financeRouting.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*financeRouting.getPageSize();
        financeRouting.setPageIndex(pageIndex);
        //获取财务分账列表
        List<FinanceRouting> financeRoutings = settlementLineDao.selectFinanceRoutingList(financeRouting);
        if (!financeRoutings.isEmpty()){
            responseDTO.setData(financeRoutings);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        //获取财务分账对应订单行的记录数
        Integer count = settlementLineDao.selectSettlementLineCount(financeRouting);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }
        return responseDTO;
    }

    /**
     * 根据id导出结算单列表
     * @param idSet
     * @return
     */
    @Override
    public List<Settlement> findSettlementListById(Set<Long> idSet) {
        return settlementDao.findSettlementListById(idSet);
    }

    /**
     * 根据id导出结算单行数据
     * @param idSet
     * @return
     */
    @Override
    public List<SettlementLine> findSettlementLineByIds(Set<Long> idSet) {
        return settlementLineDao.findSettlementLineByIds(idSet);
    }

    /**
     * 根据结算单行id导出财务分账信息
     * @param idSet
     * @return
     */
    @Override
    public List<FinanceRouting> selectFinancialCollectingById(Set<Long> idSet) {
        return settlementDao.selectFinancialCollectingById(idSet);
    }
}