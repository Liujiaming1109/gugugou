package com.gugugou.provider.aptitude.DTO;


import java.io.Serializable;

/**
 * @author: chengShaoShao
 * @Title: SelectListDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/10 16:12
 */
public class SelectListDTO implements Serializable {

    private static final long serialVersionUID = 3955556250125813134L;
    /**资质表主键id**/
    private Integer id;
    /**资质授权到期时间**/
    private String trademarkEndDate;
    /**负责人邮箱**/
    private String principalEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrademarkEndDate() {
        return trademarkEndDate;
    }

    public void setTrademarkEndDate(String trademarkEndDate) {
        this.trademarkEndDate = trademarkEndDate;
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail;
    }
}