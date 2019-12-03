package com.gugugou.provider.aptitude.DTO;

import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: ResponseDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/3 16:53
 */
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = -6768326715373714855L;
    private Object data;

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
