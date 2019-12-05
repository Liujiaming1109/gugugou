package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.dao.InvoiceDao;
import com.gugugou.provider.settlement.model.Invoice;
import com.gugugou.provider.settlement.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/4 17:00
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Resource
    private InvoiceDao invoiceDao;

    /**
     * 根据id查询商家开票信息
     * @param id
     * @return
     */
    @Override
    public Invoice getInvoiceById(Integer id) {

        return invoiceDao.getInvoiceById(id);
    }

    @Override
    public ResponseDTO selectTicketList(Invoice invoice) {

        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex = (invoice.getPageIndex()- ProviderCentreConsts.INTEGER_ONE)*invoice.getPageSize();
        invoice.setPageIndex(pageIndex);
        List<Invoice> invoiceList = invoiceDao.selectInvoiceList(invoice);
        if (!invoiceList.isEmpty()){
            responseDTO.setData(invoiceList);
        }else {
            //没有数据返回一个空的数组
            responseDTO.setData(new ArrayList<>());
        }
        //获取商户开票信息的记录数
        Integer count = invoiceDao.selectInvoiceCount(invoice);
        if (count != null && count>ProviderCentreConsts.INTEGER_ZERO){
            responseDTO.setCount(count);
        }
        return responseDTO;
    }
}
