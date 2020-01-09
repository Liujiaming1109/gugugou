package com.gugugou.provider.commodity.dao;

import com.gugugou.provider.commodity.model.ItemModel;

import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: ItemDao
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 20:41
 */
public interface ItemDao {

    /**
     * 带分页条件搜索商品
     * @param itemModel
     * @return
     */
    List<ItemModel> searchItemList(ItemModel itemModel);


    /**
     * 带分页条件搜索商品数量
     * @param itemModel
     * @return
     */
    Long searchItemListCount(ItemModel itemModel);
}
