package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.dto.response.ItemResponse;
import com.gugugou.provider.commodity.model.ItemPathModel;

/**
 * @author: chengShaoShao
 * @Title: ItemPathDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/7 21:24
 */
public interface ItemPathDao {

    /**
     * 新增商品路径关系表
     * @param itemPathModel
     * @return
     */
    Long insertItemPath(ItemPathModel itemPathModel);

    /**
     * 查询单条商品对应的品牌id
     * @param id
     * @return
     */
    ItemResponse selectItemBrandIdById(Long id);
}
