package com.gugugou.provider;



import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class ProviderApplicationTests {

   /* *//**计算当前时间的下一天的23:59:00*//*
    @Test
    public void  countDay(){
        *//**日结*//*
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期:"+sf.format(c.getTime()));
        c.add(Calendar.DAY_OF_MONTH, 1);
        String sad =sf.format(c.getTime()) + " " +"23:59:00";
        System.out.println("增加一天后日期:"+sad);
        //return sad;
    }

   *//**周结或两周结*//*
    @Test
    public void dateToWeek() {
        Date date = new Date();
        DateFormat format = DateFormat.getDateInstance();
        String tuesday = format.format(date);
        System.out.println("Today is : " + tuesday);
        date = getNextTuesday(date);
        String nextTuesday = format.format(date);
        String nexts = nextTuesday +" "+ "23:59:00";
        System.out.println("Next tuesday is: "+ nexts);
        //return nexts;
    }
    @Test
    public  Date getNextTuesday(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        *//**
         * ammount:0 代表最近的周二
         * 1:代表下一周周二
         * 2:代表下下周周二*//*
        cal.add(Calendar.WEEK_OF_YEAR, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        return cal.getTime();
    }*/


      /**获取当前年月
       * 月结
       *
       * */
     /* @Test
      public void getDateMonth(){
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
              int month = cal.get(Calendar.MONTH )+1;
              nextDate =  year + "-" + month + "-" + "25" + " " + "23:59:00";
          }
          System.out.println("-----------------------"+nextDate);
          //return nextDate;
    }*/

     /**年结*/
   /*  @Test
     public void getDateYear(){
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
         //return nextDate;
     }*/


    /**获取当前月份*/
    @Test
    public void dates() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        // 获取当前年
        int year = calendar.get(Calendar.YEAR);
        // 获取当前月
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("当前年份是:"+year);
        System.out.println("当前月份是:"+month);
        /**当月15号*/

    }



   /* public static String getSysYear() {

        Calendar date = Calendar.getInstance();

        String year = String.valueOf(date.get(Calendar.YEAR));

        return year;
    }*/


}
