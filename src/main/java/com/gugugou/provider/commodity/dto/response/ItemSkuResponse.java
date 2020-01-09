package com.gugugou.provider.commodity.dto.response;

import com.gugugou.provider.commodity.model.ItemModel;
import com.gugugou.provider.commodity.model.SkuModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: ItemSkuResponse
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 20:10
 */
@Data
public class ItemSkuResponse implements Serializable {

    private static final long serialVersionUID = -6548640988511381033L;
    private ItemModel itemModel;

    private List<SkuModel> skuModelList;

}
