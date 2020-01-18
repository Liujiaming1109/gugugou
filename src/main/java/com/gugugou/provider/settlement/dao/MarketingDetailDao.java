package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.MarketingDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2020/1/15 21:00
 */
@Mapper
public interface MarketingDetailDao {

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
    List<MarketingDetail> selectMarketingDetails(MarketingDetail marketingDetail);

    /**
     * 查询营销明细表的记录数
     * @param marketingDetail
     * @return
     */
    Integer selectMarketingDetailCount(MarketingDetail marketingDetail);

    /**
     * 根据id集合查找营销数据
     * @param idSet
     * @return
     */
    List<MarketingDetail> findMarketingDetailByIds(@Param("idSet") Set<Long> idSet);
}
