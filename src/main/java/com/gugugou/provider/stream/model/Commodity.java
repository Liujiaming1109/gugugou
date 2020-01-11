package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Commodity implements Serializable {
    /**主键id*/
    private Long id;

    /**扩展类型*/
    private int  ExtensionType;

    /**未知*/
    private int spuId;

    /**主播间id*/
    private Long  anchorId;

    /**商品id*/
    private Long itemId;

    /**租户id*/
    private Long tenantId;

    /**商品计量单位*/
    private int unit;

    /**商品编码*/
    private String itemCode;

    /**店铺id*/
    private Long shopId;

    /**品牌id*/
    private Long BrandId;

    /**品牌名*/
    private String brandName;

    /**运费模板id*/
    private Long deliveryFeeTemp;

    /**商品名*/
    private String name;

    /**未知*/
    private String advertise;

    /**主图地址*/
    private String mainImage;

    /**视频地址*/
    private String videoUrl;

    /**商品状态*/
    private String status;

    /**商品类型*/
    private int type;

    /**业务类型*/
    private String bussinessType;

    /**sku销售属性集合*/
    private String skuAttributesJson;

    /**其他属性*/
    private String otherAttributesJson;

    /**其他内容*/
    private String extraJson;

    /**位标*/
    private int bitTag;

    /**md5Info*/
    private String md5Info;

    /**信息版本号*/
    private String version;

    /**创建时间*/
    private Date createdAt;

    /**最后更新时间*/
    private Date updatedAt;

    /**最后更新者*/
    private String updatedBy;

    /**商品描述*/
    private String commodityDescribe;

    /**价格*/
    private String commodityPrice;

    /**编号*/
    private String serialNumber;

    /**创建人*/
    private String createdBy;

    /**逻辑删除*/
    private int removed;
}
