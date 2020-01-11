package com.gugugou.provider.commodity.dto.request;

import com.gugugou.provider.commodity.dto.response.ItemResponse;
import com.gugugou.provider.commodity.model.ItemModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: AddCommodityRequest
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 10:47
 */
@Data
public class AddCommodityRequest implements Serializable {


    private static final long serialVersionUID = 3987547236500072813L;
    private Long pathId;

    private List<ItemModel> itemModelList;
}
