package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.ReverseOrderDetail;
import com.gugugou.provider.settlement.service.ReverseOrderDetailService;
import com.wuwenze.poi.ExcelKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

/**
 * @author: yuelitao
 * @date 2020/1/17 12:02
 */
@RestController
@RequestMapping("reverseOrder")
public class ReverseOrderDetailController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReverseOrderDetailService reverseOrderDetailService;

    @PostMapping("detail/selectReverseOrderDetailList")
    public ResponseDTO selectReverseOrderDetailList(@RequestBody ReverseOrderDetail reverseOrderDetail){

        logger.info("分页查询逆向单详情列表的入参--reverseOrderDetail: {}",reverseOrderDetail);
        return reverseOrderDetailService.selectReverseOrderDetailList(reverseOrderDetail);
    }

    /**
     * 根据id集合导出退货单明细
     * @param idSet
     * @param response
     */
    @GetMapping("findReverseOrderDetailById/excel")
    public void findReverseOrderDetailById(@RequestParam("idSet") Set<Long> idSet, HttpServletResponse response) {
        logger.info("根据id集合导出退货单明细的入参--idSet", idSet);
        List<ReverseOrderDetail> reverseOrderDetailById = reverseOrderDetailService.findReverseOrderDetailById(idSet);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!reverseOrderDetailById.isEmpty()) {
            for (ReverseOrderDetail reverseOrderDetail:reverseOrderDetailById) {
                String format = formatter.format(reverseOrderDetail.getPayAt());
                reverseOrderDetail.setPayAtExcel(format);
                String format1 = formatter.format(reverseOrderDetail.getAccomplishAt());
                reverseOrderDetail.setAccomplishAtExcel(format1);
                String format2 = formatter.format(reverseOrderDetail.getRefundAt());
                reverseOrderDetail.setRefundAtExcel(format2);
            }
        }
        ExcelKit.$Export(ReverseOrderDetail.class, response).downXlsx(reverseOrderDetailById, false);
    }
}
