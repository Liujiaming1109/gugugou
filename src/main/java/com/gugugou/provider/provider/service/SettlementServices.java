package com.gugugou.provider.provider.service;

import com.gugugou.provider.provider.model.Information;


/**
 * 供应商基本信息---结算下一次的结算时间*/

public interface SettlementServices {

    /**供应商基本信息----计算下一次结算周期*/
    String settlementTime(Information information);
}
