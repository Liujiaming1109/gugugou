package com.gugugou.provider.provider.service.Impl;

import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.service.SettlementServices;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Service
public class SettlementServiceImpls implements SettlementServices {


    /**
     * 计算下一次的结算时间
     * */
    @Override
    public String settlementTime(Information information) {
        String settlementTimeNext = "";
        /**获取结算类型*/
        int settlementInterval = information.getSettlementInterval();
        /**获取上次的结算时间*/
        Date lastSettlementTime = information.getLastSettlementTime();
        /**判断结算类型*/
        if(settlementInterval == 0){
                /**日结*/
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                System.out.println("当前日期:"+sf.format(c.getTime()));
                c.add(Calendar.DAY_OF_MONTH, 1);
                String sad =sf.format(c.getTime()) + " " +"23:59:00";
                System.out.println("增加一天后日期:"+sad);
                settlementTimeNext = sad;

        }else if (settlementInterval == 1){
            /**周结*/
            Date date = new Date();
            DateFormat format = DateFormat.getDateInstance();
            String tuesday = format.format(date);
            System.out.println("Today is : " + tuesday);
            date = getNextTuesday(date);
            String nextTuesday = format.format(date);
            String nexts = nextTuesday +" "+ "23:59:00";
            System.out.println("Next tuesday is: "+ nexts);
            settlementTimeNext = nexts;

        }else if(settlementInterval == 2){
            /**周结*/
            Date date = new Date();
            DateFormat format = DateFormat.getDateInstance();
            String tuesday = format.format(date);
            System.out.println("Today is : " + tuesday);
            date = getNextTuesdayTwo(date);
            String nextTuesday = format.format(date);
            String nextss = nextTuesday +" "+ "23:59:00";
            System.out.println("Next tuesday is: "+ nextss);
            settlementTimeNext = nextss;

        }else if(settlementInterval == 3){
                 /**月结*/
                //下次结算日期
                String nextDate = null;
                SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //获取当前年月日
                ParsePosition pos = new ParsePosition(0);
                Date date1 = new Date();
                //Date date1 = df.parse(df.format(new Date()) +"-28 18:00:00",pos);
                //获取当前年月,拼接25号
                Date date2 = df.parse(dfs.format(new Date()) + "-" +"25" + " " + "23:59:00",pos);
                //日期比较
                long beginMillisecond = date1.getTime();
                long endMillisecond = date2.getTime();
                if(beginMillisecond < endMillisecond){
                    //如果当前年月日小于当前年月+25号日期,则下一结算日期为拼接后的日期
                    nextDate = dfs.format(new Date()) + "-" +"25" + " " + "23:59:00";
                } else {
                    //如果当前年月大于当前年月+25号日期
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH) + 1;
                    nextDate = year + "-" + month + "-" + "25" + " " + "23:59:00";
                }
                System.out.println("-----------------------"+nextDate);
                 settlementTimeNext = nextDate;

        }else if(settlementInterval ==4){

            /**年结*/
            //下次结算日期
            String nextDate = null;
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //获取当前年月日
            ParsePosition pos = new ParsePosition(0);
            Date date1 = new Date();
            //Date date1 = df.parse(df.format(new Date()) +"-28 18:00:00",pos);
            //获取当前年月,拼接25号
            Date date2 = df.parse(dfs.format(new Date())+ "-" + "12" + "-" +"25" + " " + "23:59:00",pos);
            //日期比较
            long beginMillisecond = date1.getTime();
            long endMillisecond = date2.getTime();
            if(beginMillisecond < endMillisecond){
                //如果当前年月日小于当前年月+25号日期,则下一结算日期为拼接后的日期
                nextDate = dfs.format(new Date())+ "-" + "12" + "-" +"25" + " " + "23:59:00";
            } else {
                //如果当前年月大于当前年月+25号日期
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR)+1;
                int month = cal.get(Calendar.MONTH )+1;
                nextDate =  year + "-" + month + "-" + "25" + " " + "23:59:00";
            }
            System.out.println("下一次年结时间"+nextDate);
            settlementTimeNext = nextDate;

        }


        return settlementTimeNext;
    }

    /**最近一周的周二结算日期*/
    public  Date getNextTuesday(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        /**
         * ammount:0 代表最近的周二
                * 1:代表下一周周二
                * 2:代表下下周周二*/
                cal.add(Calendar.WEEK_OF_YEAR, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        return cal.getTime();
    }

    /**最近下下周的周二结算日期*/
    public  Date getNextTuesdayTwo(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        /**
         * ammount:0 代表最近的周二
         * 1:代表下一周周二
         * 2:代表下下周周二*/
        cal.add(Calendar.WEEK_OF_YEAR, 2);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        return cal.getTime();
    }
}
