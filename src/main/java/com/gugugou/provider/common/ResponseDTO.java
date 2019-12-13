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

    private static final long serialVersionUID = 4239637436041458239L;
    /** 分页数据 */
    private Object data;
    /** 分页数据条数 */
    private long count;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
