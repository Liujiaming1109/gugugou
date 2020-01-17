package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.dao.MarketingDetailDao;
import com.gugugou.provider.settlement.model.MarketingDetail;
import com.gugugou.provider.settlement.service.MarketingDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/16 10:32
 */
@Service
public class MarketingDetailServiceImpl implements MarketingDetailService{

    @Resource
    private MarketingDetailDao marketingDetailDao;

    @Override
    public Integer addMarketingDetail(List<MarketingDetail> marketingDetails) {

        return marketingDetailDao.addMarketingDetail(marketingDetails);
    }

    @Override
    public ResponseDTO selectMarketingDetails(MarketingDetail marketingDetail) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex= (marketingDetail.getPageIndex()- ProviderCentreConsts.INTEGER_ONE) * marketingDetail.getPageSize();
        marketingDetail.setPageIndex(pageIndex);
        //获取营销明细列表
        List<MarketingDetail> marketingDetails = marketingDetailDao.selectMarketingDetails(marketingDetail);
        if (!marketingDetails.isEmpty()){
            responseDTO.setData(marketingDetails);
        }else {
            responseDTO.setData(new ArrayList<>());
        }
        //获取营销明细表的记录数
        Integer count = marketingDetailDao.selectMarketingDetailCount(marketingDetail);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }

        return responseDTO;
    }
}
