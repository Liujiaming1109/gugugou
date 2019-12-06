package com.gugugou.provider.common.until;

/**
 * @author: chengShaoShao
 * @Title: DaysToMillis
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/6 17:30
 */
public class DaysToMillis {

    /**
     * 天数转换成时间戳
     * @param days
     * @return
     */
    public static long daysToMillis(long days)
    {
        long daysInMillis = days * 24L * 60L * 60000L;
        return daysInMillis;
    }
}
