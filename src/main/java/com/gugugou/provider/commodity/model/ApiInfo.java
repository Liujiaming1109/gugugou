package com.gugugou.provider.commodity.model;

import java.io.Serializable;

public class ApiInfo implements Serializable {
    private static final long serialVersionUID = -7684565099233424514L;

    public ApiInfo() {
    }

    @Override
    public boolean equals(Object o) {
        return o == this || o instanceof ApiInfo;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}