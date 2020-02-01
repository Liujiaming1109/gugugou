package com.gugugou.provider.stream.controller;

import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.model.MyAttention;
import com.gugugou.provider.stream.service.MyAttentionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/30 23:23
 */
@RestController
@RequestMapping("myAttention")
public class MyAttentionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MyAttentionService myAttentionService;

    @PostMapping("addAttention")
    public Integer addAttention(@RequestBody MyAttention myAttention){
        logger.info("新增我的关注入参--myAttention:{}",myAttention);
        return myAttentionService.addMyAttention(myAttention);
    }

    @GetMapping("selectMyAttentions")
    public List<ArrangeStreaming> selectMyAttentions(@RequestParam Long userId){
        logger.info("查询我的关注入参--userId:{}",userId);
        return myAttentionService.selectMyAttentions(userId);
    }
}
