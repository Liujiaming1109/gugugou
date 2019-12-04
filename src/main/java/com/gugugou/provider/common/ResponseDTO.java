package com.gugugou.provider.common;

import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: ResponseDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/3 16:53
 */
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = -2253382736414846371L;
    /** 分页数据 */
    private Object data;
    /** 分页数据条数 */
    private Integer count;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
