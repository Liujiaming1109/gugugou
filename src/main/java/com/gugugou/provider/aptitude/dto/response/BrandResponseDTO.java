package com.gugugou.provider.aptitude.dto.response;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.aptitude.model.BrandModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: BrandResponseDTO
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/4 10:53
 */
public class BrandResponseDTO implements Serializable {

    private static final long serialVersionUID = 6065861699806682643L;
    /** 附件封装类 */
    private List<AccessoryUrlModel> accessoryUrlModelList;
    /** 品牌资质封装类 */
    private BrandModel brandModel;

    public List<AccessoryUrlModel> getAccessoryUrlModelList() {
        return accessoryUrlModelList;
    }

    public void setAccessoryUrlModelList(List<AccessoryUrlModel> accessoryUrlModelList) {
        this.accessoryUrlModelList = accessoryUrlModelList;
    }

    public BrandModel getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(BrandModel brandModel) {
        this.brandModel = brandModel;
    }
}
