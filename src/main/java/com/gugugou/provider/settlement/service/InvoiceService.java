package com.gugugou.provider.settlement.service;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.Invoice;

/**
 * @author: yuelitao
 * @date 2019/12/4 17:00
 */
public interface InvoiceService {

    /**
     * 根据id查询商家开票信息
     * @param id
     * @return
     */
    Invoice getInvoiceById(Long id);

    /**
     * 查询商家开票信息列表
     * @param invoice
     * @return
     */
    ResponseDTO selectTicketList(Invoice invoice);
}
