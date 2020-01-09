package com.gugugou.provider.commodity.model;

import java.util.Map;

public class ApiExtInfo extends ApiInfo {
    private static final long serialVersionUID = -7684565099233424514L;
    private Integer tenantId;
    private Map<String, String> extra;

    public Integer getTenantId() {
        return this.tenantId;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }

    public ApiExtInfo() {
    }
}
