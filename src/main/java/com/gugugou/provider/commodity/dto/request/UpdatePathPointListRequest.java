package com.gugugou.provider.commodity.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: UpdatePathPointListRequest
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 18:45
 */
@Data
public class UpdatePathPointListRequest implements Serializable {

    private static final long serialVersionUID = 4133926029730303810L;
    private List<Long> ids;

    private Integer point;
}
