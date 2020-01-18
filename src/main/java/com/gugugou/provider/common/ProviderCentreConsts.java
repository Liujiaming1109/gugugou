package com.gugugou.provider.common;

/**
 * @author: chengShaoShao
 * @Title: ProviderCentreConsts
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/2 16:17
 */
public final class  ProviderCentreConsts {

    private ProviderCentreConsts() {
    }

    /**
     * 逻辑删除状态：0
     */
    public static final Integer REMOVED_ZERO = 0;

    /**
     * 附件来源：（0：供应商，1：品牌资质，2：违规处罚管理）
     */
    public static  final  Integer ACCESSORY_RESOURCE_ZERO = 0;
    public static  final  Integer ACCESSORY_RESOURCE_ONE = 1;
    public static  final  Integer ACCESSORY_RESOURCE_TWO = 2;

    /**
     * 附件在品牌资质的具体位置
     * （0：商标权人出具的授权书，1：商标注册证，2：检测报告，3：产品清单，
     * 4：《食品经营许可证》或 《食品流通许可证》，5：《食品生产许可证》&产品涉及委托加工，
     * 6：《商品出入境检验检疫卫生证书》或《商品出入境检验检疫卫生证明》，
     * 7：《食盐批发[含转(代)批发]许可证》，8：中华人民共和国海关进口货物报关单，
     * 9：清真食品认证（国际Halal认证），10：有机食品认证，
     * 11：贵司近3个月内向上一级经销商的进货发票复印件，且发票需体现此次申请的品牌名称）
     */
    public static  final  Integer BRAND_ADDRESS_ZERO = 0;
    public static  final  Integer BRAND_ADDRESS_ONE = 1;
    public static  final  Integer BRAND_ADDRESS_TWO = 2;
    public static  final  Integer BRAND_ADDRESS_THREE = 3;
    public static  final  Integer BRAND_ADDRESS_FOUR = 4;
    public static  final  Integer BRAND_ADDRESS_FIVE = 5;
    public static  final  Integer BRAND_ADDRESS_SIX = 6;
    public static  final  Integer BRAND_ADDRESS_SEVEN = 7;
    public static  final  Integer BRAND_ADDRESS_EIGHT = 8;
    public static  final  Integer BRAND_ADDRESS_NINE = 9;
    public static  final  Integer BRAND_ADDRESS_TEN = 10;
    public static  final  Integer BRAND_ADDRESS_ELEVEN = 11;

    /**
     * 常用整型 数字
     **/
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_THREE = 3;
    public static final Integer INTEGER_FOUR = 4;
    public static final Integer INTEGER_FIVE = 5;
    public static final Integer INTEGER_SIX = 6;
    public static final Integer INTEGER_SEVEN = 7;
    public static final Integer INTEGER_EIGHT = 8;
    public static final Integer INTEGER_NINTH = 9;

    /**
     * 供应商授权状态
     * 0：正常，1：即将过期，2：过期，3：未开始
     */
    public static final Integer TRADEMARK_STATUS_ZERO = 0;
    public static final Integer TRADEMARK_STATUS_ONE = 1;
    public static final Integer TRADEMARK_STATUS_TWO = 2;
    public static final Integer TRADEMARK_STATUS_THREE = 3;


    /**
     * 附件在供应商资质的具体位置
     * （0：企业执照，1：税务登记，2：组织结构代码，
     * 3：一般纳税人资格证明，4：银行开户许可证，
     * 5：法定代表人身份证正反面，
     */
   /* public static  final  String PROVIDER_ADDRESS_ZERO = "0";
    public static  final  String PROVIDER_ADDRESS_ONE = "1";
    public static  final  String PROVIDER_ADDRESS_TWO = "2";
    public static  final  String PROVIDER_ADDRESS_THREE = "3";
    public static  final  String PROVIDER_ADDRESS_FOUR = "4";
    public static  final  String PROVIDER_ADDRESS_FIVE = "5";*/

    public static  final  Integer PROVIDER_ADDRESS_ZERO = 0;
    public static  final  Integer PROVIDER_ADDRESS_ONE = 1;
    public static  final  Integer PROVIDER_ADDRESS_TWO = 2;
    public static  final  Integer PROVIDER_ADDRESS_THREE = 3;
    public static  final  Integer PROVIDER_ADDRESS_FOUR = 4;
    public static  final  Integer PROVIDER_ADDRESS_FIVE = 5;

}
