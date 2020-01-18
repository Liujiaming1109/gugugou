package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.MarketingDetail;
import com.gugugou.provider.settlement.service.MarketingDetailService;
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
 * @date 2020/1/16 11:15
 */
@RestController
@RequestMapping("marketing")
public class MarketingDetailController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MarketingDetailService marketingDetailService;

    @PostMapping("detail/selectMarketingDetailList")
    public ResponseDTO selectMarketingDetailList(@RequestBody MarketingDetail marketingDetail){
        logger.info("查询营销明细列表的入参--marketingDetail : {}",marketingDetail);
        return marketingDetailService.selectMarketingDetails(marketingDetail);
    }

    /**
     * 导出营销明细
     * @param idSet
     * @param response
     */
    @GetMapping("findMarketingDetailByIds/excel")
    public void findMarketingDetailByIds(@RequestParam("idSet") Set<Long> idSet, HttpServletResponse response) {
        logger.info("导出营销明细的入参--idSet：{}", idSet);
        List<MarketingDetail> marketingDetailByIds = marketingDetailService.findMarketingDetailByIds(idSet);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!marketingDetailByIds.isEmpty()) {
            for (MarketingDetail marketingDetail:marketingDetailByIds) {
                String format = formatter.format(marketingDetail.getOrderPaymentTime());
                marketingDetail.setOrderPaymentTimeExcel(format);
                String format1 = formatter.format(marketingDetail.getOrderSuccessfulTime());
                marketingDetail.setOrderSuccessfulTimeExcel(format1);
            }
        }
        ExcelKit.$Export(MarketingDetail.class, response).downXlsx(marketingDetailByIds,false);
    }
}
