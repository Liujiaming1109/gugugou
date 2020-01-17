package com.gugugou.provider.common.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: TimeToStamp
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/25 18:19
 */
public class TimeToStamp {

    /**
     *yyyy-MM-dd格式转换为时间戳
     */
    public static long timeToStamp(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将你的日期转换为时间戳
        Date datetime = sdf.parse(time);
        return datetime.getTime();
    }

    /**
     * 将long类型的时间戳转换为yyyy-MM-dd格式的字符串输出
     * @param time
     * @return
     * @throws ParseException
     */
    public static String stampToTime(Long time) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(time);
        return timeStr;
    }
}
