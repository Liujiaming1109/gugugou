package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.PaymentDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: yuelitao
 * @date 2019/12/11 19:43
 */
@Mapper
public interface PaymentDetailDao {

    /**
     * 新增正向流水
     * @param paymentDetail
     * @return
     */
    Integer addPaymentDetail(PaymentDetail paymentDetail);
}
