package com.gugugou.provider.commodity.model;


import lombok.Data;

import java.io.Serializable;

import java.util.Map;

/**
 * @author zhujh
 * @version 2019-01-18 上午10:07
 */
@Data
public abstract class AbstractSO implements Serializable {
    public static final Long MAX_RESULT_WINDOW = 10000L;
    private int pageNo = 1;
    private int pageSize = 20;

    private Integer tenantId;
    private Integer offset;
    private Integer limit;
    private Map<String, Object> sourceCondition;
//    private List<MetaInCondition> inCondition;

    public Integer getOffset() {
        if (null == offset) {
            init();
        }
        return offset;
    }

    public Integer getLimit() {
        if (null == limit) {
            init();
        }
        return limit;
    }

    private void init() {
        // 分页参数
        this.limit = this.pageSize;
        this.offset = (this.pageNo - 1) * this.pageSize;
        // 搜索深度分页控制
        this.offset = (this.limit + this.offset > MAX_RESULT_WINDOW.intValue()) ? (MAX_RESULT_WINDOW.intValue() - this.limit) : this.offset;
    }
}
