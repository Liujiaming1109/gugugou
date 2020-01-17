package com.gugugou.provider.settlement.controller;

import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.model.ReverseOrderDetail;
import com.gugugou.provider.settlement.service.ReverseOrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
