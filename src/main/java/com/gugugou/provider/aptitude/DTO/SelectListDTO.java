package com.gugugou.provider.aptitude.DTO;

import com.gugugou.provider.aptitude.model.BrandModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: SelectListDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/10 16:12
 */
public class SelectListDTO implements Serializable {

    private static final long serialVersionUID = -1636770920197946786L;
    /**资质表主键id**/
    private Integer id;
    /**资质授权到期时间**/
    private List<BrandModel> brandModelList;
    /**负责人邮箱**/
    private String principalEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BrandModel> getBrandModelList() {
        return brandModelList;
    }

    public void setBrandModelList(List<BrandModel> brandModelList) {
        this.brandModelList = brandModelList;
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail;
    }
}
