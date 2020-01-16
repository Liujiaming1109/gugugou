package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.MarketingDetail;
import com.gugugou.provider.settlement.service.MarketingDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
