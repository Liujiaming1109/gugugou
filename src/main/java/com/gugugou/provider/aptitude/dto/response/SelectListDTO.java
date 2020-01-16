package com.gugugou.provider.aptitude.dto.response;


import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: SelectListDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/10 16:12
 */
public class SelectListDTO implements Serializable {

    private static final long serialVersionUID = -4133182566662861801L;
    /**资质表主键id**/
    private Long id;
    /**资质授权到期时间**/
    private String trademarkEndDate;
    /**资质授权到期时间**/
    private String trademarkStartDate;
    /**负责人邮箱**/
    private String principalEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrademarkEndDate() {
        return trademarkEndDate;
    }

    public void setTrademarkEndDate(String trademarkEndDate) {
        this.trademarkEndDate = trademarkEndDate;
    }

    public String getTrademarkStartDate() {
        return trademarkStartDate;
    }

    public void setTrademarkStartDate(String trademarkStartDate) {
        this.trademarkStartDate = trademarkStartDate;
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail;
    }
}
