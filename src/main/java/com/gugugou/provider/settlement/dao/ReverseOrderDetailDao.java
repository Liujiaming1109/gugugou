package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.ReverseOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2020/1/17 10:59
 */
@Mapper
public interface ReverseOrderDetailDao {

    /**
     * 新增逆向单明细
     * @param reverseOrderDetails
     * @return
     */
    Integer addReverseOrderDetail(List<ReverseOrderDetail> reverseOrderDetails);

    /**
     * 根据条件分页查询逆向单明细列表
     * @param reverseOrderDetail
     * @return
     */
    List<ReverseOrderDetail> selectReverseOrderDetailList(ReverseOrderDetail reverseOrderDetail);

    /**
     * 统计逆向单明细表的记录数
     * @param reverseOrderDetail
     * @return
     */
    Integer selectReverseOrderDetailCount(ReverseOrderDetail reverseOrderDetail);

    /**
     * 根据id集合查询退货单明细
     * @param idSet
     * @return
     */
    List<ReverseOrderDetail> findReverseOrderDetailById(@Param("idSet") Set<Long> idSet);
}
