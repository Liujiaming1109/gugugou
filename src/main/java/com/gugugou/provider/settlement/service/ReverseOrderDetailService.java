package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.ReverseOrderDetail;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/17 11:58
 */
public interface ReverseOrderDetailService {

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
    ResponseDTO selectReverseOrderDetailList(ReverseOrderDetail reverseOrderDetail);
}
