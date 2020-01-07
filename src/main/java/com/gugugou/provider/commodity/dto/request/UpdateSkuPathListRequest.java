package com.gugugou.provider.commodity.dto.request;

import com.gugugou.provider.commodity.dto.model.UpdateSkuPathModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: UpdateSkuPathList
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/7 11:32
 */
@Data
public class UpdateSkuPathListRequest implements Serializable {

    private static final long serialVersionUID = 1768405326812252688L;
    /**
     * 扣点
     */
    private Integer point;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * id集合
     */
    private List<UpdateSkuPathModel> updateSkuPathModels;

}
