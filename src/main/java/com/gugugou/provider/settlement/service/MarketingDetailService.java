package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.MarketingDetail;

import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2020/1/16 10:32
 */
public interface MarketingDetailService {

    /**
     * 新增营销明细
     * @param marketingDetails
     * @return
     */
    Integer addMarketingDetail(List<MarketingDetail> marketingDetails);

    /**
     * 分页查询营销明细
     * @param marketingDetail
     * @return
     */
    ResponseDTO selectMarketingDetails(MarketingDetail marketingDetail);

    /**
     * 根据id集合导出营销明细
     * @param idSet
     * @return
     */
    List<MarketingDetail> findMarketingDetailByIds(Set<Long> idSet);
}
