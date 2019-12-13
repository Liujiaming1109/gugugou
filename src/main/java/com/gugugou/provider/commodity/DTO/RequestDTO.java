package com.gugugou.provider.commodity.DTO;

import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: RequestDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/11 16:55
 */
public class RequestDTO implements Serializable {

    private static final long serialVersionUID = 7769603424377733607L;
    /** 当前页面 */
    private Integer pageIndex;
    /** 每页数据 */
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
