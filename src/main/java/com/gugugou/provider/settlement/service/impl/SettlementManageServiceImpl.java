package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.dao.SettlementManageDao;
import com.gugugou.provider.settlement.model.SettlementManage;
import com.gugugou.provider.settlement.service.SettlementManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:49
 */
@Service
public class SettlementManageServiceImpl implements SettlementManageService {

    @Resource
    private SettlementManageDao settlementManageDao;

    /**
     * 新增结算单管理
     * @param settlementManage
     * @return
     */
    @Override
    public Integer addSettlementManage(SettlementManage settlementManage) {

        return settlementManageDao.addSettlementManage(settlementManage);
    }

    /**
     * 分页查询结算单管理
     * @param settlementManage
     * @return
     */
    @Override
    public ResponseDTO selectSettlementManageList(SettlementManage settlementManage) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex= (settlementManage.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*settlementManage.getPageSize();
        settlementManage.setPageIndex(pageIndex);
        //获取结算单管理列表
        List<SettlementManage> settlementManages = settlementManageDao.selectSettlementManageList(settlementManage);
        if (!settlementManages.isEmpty()){
            responseDTO.setData(settlementManages);
        }else {
            //如果为空，返回一个空数组
            responseDTO.setData(new ArrayList<>());
        }
        //获取结算单管理表记录数
        Integer count = settlementManageDao.selectSettlementManageCount(settlementManage);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }

        return responseDTO;
    }
}
