package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.Invoice;
import com.gugugou.provider.settlement.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yuelitao
 * @date 2019/12/4 17:01
 */
@RestController
@RequestMapping("provider")
public class InvoiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InvoiceService invoiceService;

    /**
     * 查询单条商家开票信息
     * @param id
     * @return
     */
    @GetMapping("invoice/getInvoiceByProviderId")
    public Invoice getInvoiceByProviderId(@RequestParam Long id){

        logger.info("查询商家开票信息的入参：{}",id);
        return invoiceService.getInvoiceById(id);
    }

    /**
     * 查询所有商家开票信息列表
     * @param invoice
     * @return
     */
    @PostMapping("invoice/selectInvoiceList")
    public ResponseDTO selectInvoiceList(@RequestBody Invoice invoice){

        logger.info("查询商家开票信息列表的入参：{}",invoice);
        return invoiceService.selectTicketList(invoice);
    }
}
