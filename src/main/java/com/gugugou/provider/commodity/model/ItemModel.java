package com.gugugou.provider.commodity.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: ItemModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 16:12
 */
@Data
public class ItemModel extends AbstractSO {


    private Long pathId;

    @ApiModelProperty("商品id")
    private Long id;
    @ApiModelProperty("SPU id")
    private Long spuId;
    @ApiModelProperty("租户id")
    private Integer tenantId;
    @ApiModelProperty("叶子类目id")
    private Long categoryId;
    @ApiModelProperty(value = "叶子类目名称", notes = "主搜不关注此字段，为空")
    private String categoryName;
    @ApiModelProperty("商品编码")
    private String itemCode;
    @ApiModelProperty("店铺id")
    private Long shopId;
    @ApiModelProperty("店铺名")
    private String shopName;
    @ApiModelProperty("品牌id")
    private Long brandId;
    @ApiModelProperty("品牌名")
    private String brandName;
    @ApiModelProperty("商品名")
    private String name;
    @ApiModelProperty("商品主图URL")
    private String mainImage;
    @ApiModelProperty(value = "商品状态", notes = "1:上架,-1:下架,-2:冻结,-3:删除")
    private Integer status;
    @ApiModelProperty("审核状态")
    private Integer auditStatus;
    @ApiModelProperty("商品类型")
    private Integer type;
    @ApiModelProperty("业务类型")
    private Integer businessType;
    @ApiModelProperty("更新时间")
    private Date updatedAt;
    @ApiModelProperty(value = "最高售价")
    private Long highPrice;
    @ApiModelProperty(value = "最低售价")
    private Long lowPrice;
    @ApiModelProperty(value = "销量", notes = "订单消息同步")
    private Long saleQuantity;
    @ApiModelProperty(value = "是否有货", notes = "库存消息同步")
    private Integer inStock;
    @ApiModelProperty("后台类目1-n级")
    private List<Long> categoryIds;
    @ApiModelProperty("店铺类目1-n级")
    private List<Long> shopCategoryIds;
    @ApiModelProperty("创建来源")
    private String source;
//    @ApiModelProperty("促销活动信息")
//    private List<Activity> activities;

    private List<SkuModel> skuModelList;
}
