package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.dao.SettlementDao;
import com.gugugou.provider.settlement.dao.SettlementLineDao;
import com.gugugou.provider.settlement.model.Settlement;
import com.gugugou.provider.settlement.model.SettlementLine;
import com.gugugou.provider.settlement.service.SettlementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        //先查出结算单
        Settlement settlementDO = settlementDao.getSettlementById(id);
        if (settlementDO != null){
            //再查出结算单行数据
            List<SettlementLine> settlementLines = settlementLineDao.selectSettlementLinesBySettlementId(id);
            if (!settlementLines.isEmpty()){
                settlementDO.setSettlementLines(settlementLines);
            }
        }
        return settlementDO;
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
        //获取结算单管理表记录数
        Integer count = settlementDao.selectSettlementCount(settlement);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }

        return responseDTO;
    }

    @Override
    public ResponseDTO selectSettlementListForFinance(Settlement settlement) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex= (settlement.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*settlement.getPageSize();
        settlement.setPageIndex(pageIndex);
        //获取结算单列表
        List<Settlement> settlements = settlementDao.selectSettlementList(settlement);
        if (!settlements.isEmpty()){
            for (Settlement settlementDO : settlements) {
                //获取该结算单下得所有结算单行数据
                List<SettlementLine> settlementLines = settlementLineDao.selectSettlementLinesBySettlementId(settlementDO.getId());
                if (!settlementLines.isEmpty()){
                    //判断前台有没有用路径做筛选
                    if ("".equals(settlement.getPathName())){
                        //这里是没有筛选，将结算单行下的数据，设置给结算单
                        settlementDO.setSettlementLines(settlementLines);
                    }else {
                        //这里对结算单行数据做一个筛选
                        List<SettlementLine> settlementLineList = new ArrayList<>();
                        for (SettlementLine settlementLine : settlementLines) {
                            if (settlementLine.getPathName().equals(settlement.getPathName())){

                                settlementLineList.add(settlementLine);
                            }
                        }
                        settlementDO.setSettlementLines(settlementLineList);
                    }
                }
            }

            responseDTO.setData(settlements);
        }else {
            responseDTO.setData(new ArrayList<>());
        }

        //获取结算单管理表记录数
        Integer count = settlementDao.selectSettlementCount(settlement);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }
        return responseDTO;
    }
}
