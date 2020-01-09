package com.gugugou.provider.commodity.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: SkuModel
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 15:53
 */
@Data
public class SkuModel implements Serializable {


    private static final long serialVersionUID = -3632368980447076768L;
    @ApiModelProperty("SKU id")
    private Long id;
    @ApiModelProperty("租户id")
    private Integer tenantId;
    @ApiModelProperty("商品id")
    private Long itemId;
    @ApiModelProperty("SKU模板id")
    private Long skuTemplateId;
    @ApiModelProperty("SKU编码")
    private String skuCode;
    @ApiModelProperty("条形码")
    private String barcode;
    @ApiModelProperty("外部id")
    private String outerId;
    @ApiModelProperty("店铺id")
    private Long shopId;
    @ApiModelProperty("商品名")
    private String name;
    @ApiModelProperty("图片url")
    private String image;
    @ApiModelProperty("定价")
    private Integer originalPrice;
    @ApiModelProperty("基础售价")
    private Integer price;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("审核状态")
    private Integer auditStatus;
    @ApiModelProperty("商品类型")
    private Integer type;
    @ApiModelProperty("业务类型")
    private Integer businessType;
    @ApiModelProperty("修改时间")
    private Date updatedAt;
    @ApiModelProperty("后台类目1-n级")
    private List<Long> categoryIds;
    @ApiModelProperty("叶子类目名称")
    private String categoryName;
    @ApiModelProperty("销售属性")
    private List<SkuAttributeInfo> attributes;
    @ApiModelProperty("是否小程序展示")
    private Integer isMiniProgram;

    private Long pathId;

    public Long getCategoryId() {
        if (CollectionUtils.isEmpty(categoryIds)) {
            return null;
        }
        return categoryIds.get(categoryIds.size() - 1);
    }
}
