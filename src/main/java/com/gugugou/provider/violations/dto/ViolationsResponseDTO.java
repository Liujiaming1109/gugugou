package com.gugugou.provider.violations.dto;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.violations.model.Violations;

import java.io.Serializable;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2019/12/4 11:03
 */
public class ViolationsResponseDTO implements Serializable {
    private Violations violations;
    private List<AccessoryUrlModel> accessoryList;

    public Violations getViolations() {
        return violations;
    }

    public void setViolations(Violations violations) {
        this.violations = violations;
    }

    public List<AccessoryUrlModel> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(List<AccessoryUrlModel> accessoryList) {
        this.accessoryList = accessoryList;
    }
}
