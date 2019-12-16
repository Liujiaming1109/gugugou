package com.gugugou.provider.common.until;

import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: JsonResultVo
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/16 10:38
 */
public class JsonResultVo implements Serializable {

    private static final long serialVersionUID = 1231263533688351562L;
    private String data;

    private Integer count;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
