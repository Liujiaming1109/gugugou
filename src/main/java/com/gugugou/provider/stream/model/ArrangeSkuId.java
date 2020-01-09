package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 查找直播间与sku中间表下的sku的条件*/
@Data
@ToString
public class ArrangeSkuId implements Serializable {

    /**排班表与sku中间表的id*/
    private Long id;

    /**skuid*/
    private Long commotityId;

}
