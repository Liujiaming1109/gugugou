package com.gugugou.provider.commodity.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author <a herf="mailto:wuqi@terminus.io">xunyard</a>
 * @date 2018-07-23
 * @since 5.1
 */
@Data
@EqualsAndHashCode(of = {"id", "attrKey", "attrVal"})
public class SkuAttributeInfo extends ApiExtInfo {

    private static final long serialVersionUID = -8743816521079466773L;

    @ApiModelProperty("属性id")
    private Long id;

    @ApiModelProperty("属性所属组 , 如颜色")
    private String attrKey;

    @ApiModelProperty("属性值, 如红色")
    private String attrVal;

    @Deprecated
    @ApiModelProperty("计量单位")
    private String unit;

    @ApiModelProperty("决定是否sku图片是否展现")
    private Boolean showImage;

    @ApiModelProperty("属性对应的缩略图")
    private String thumbnail;

    @ApiModelProperty("属性对应的原图")
    private String image;


}
