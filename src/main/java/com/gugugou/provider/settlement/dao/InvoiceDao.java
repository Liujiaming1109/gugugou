package com.gugugou.provider.settlement.dao;

import com.gugugou.provider.settlement.model.Invoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/4 16:59
 */
@Mapper
public interface InvoiceDao {

    /**
     * 查询单条商家开票信息
     * @param id
     * @return
     */
    Invoice getInvoiceById(Long id);

    /**
     * 分页查询商家开票信息列表
     * @param invoice
     * @return
     */
    List<Invoice> selectInvoiceList(Invoice invoice);

    /**
     * 查询商家开票信息记录数
     * @param invoice
     * @return
     */
    Integer selectInvoiceCount(Invoice invoice);
}
