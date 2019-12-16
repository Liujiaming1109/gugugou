package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class CommoditySku implements Serializable {

    /**主键id*/
    private Long id;
    /**扩展类型*/
    private int extensionType;
    /**租户id*/
    private Long tenantId;
    /**商品id*/
    private Long commodityId;
    /**sku模板id*/
    private Long skuTemplateId;
    /**SKU编码*/
    private String skuCode;
    /**商品条码*/
    private String bracode;
    /**外部id*/
    private int otherId;
    /**shop_id*/
    private Long shopId;
    /**名称*/
    private String name;
    /**图片url*/
    private String image;
    /**实时售卖价格*/
    private int price;
    /**定价*/
    private int originalPrice;
    /**sku状态*/
    private int status;
    /**审核状态*/
    private int auditStatus;
    /**业务类型*/
    private int type;
    /**sku_ids_json*/
    private int skuIdsJson;
    /**sku其他各种价格的json*/
    private String priceJson;
    /**json存储的sku属性键值对*/
    private String attrsJson;
    /**sku信息版本*/
    private int version;
    /**sku额外信息*/
    private String extraJson;
    /**位标*/
    private int bitTag;
    /**路径*/
    private String shopSkuPath;
    /**销售属性*/
    private String sellProperty;
    /**价格*/
    private String prices;
    /**创建人*/
    private String  createdBy;
    /**创建时间*/
    private Date creatdTime;
    /**更新人*/
    private String updatedBy;
    /**更新时间*/
    private int updatedTime;
    /**逻辑删除*/
    private int removed;
}
