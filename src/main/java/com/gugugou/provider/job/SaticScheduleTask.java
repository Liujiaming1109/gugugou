package com.gugugou.provider.job;

import com.gugugou.provider.common.until.DaysToMillis;
import com.gugugou.provider.provider.controller.InformationController;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Information;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
public class SaticScheduleTask {

    @Resource
    private InformationDao informationDao;
    /**发送邮件的实现类*/
    @Resource
    private InformationController informationController;

    //3.添加定时任务
    //每天十点定时跑一次
    @Scheduled(cron = "0 0 10 * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        List<Information> informations = informationDao.findAllProvider();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeMillis = System.currentTimeMillis();
        long cron = DaysToMillis.daysToMillis(30L);
        long cron1 = DaysToMillis.daysToMillis(15L);
        long cron2 = DaysToMillis.daysToMillis(7L);
        long cron3 = DaysToMillis.daysToMillis(0L);
        for (Information information: informations) {

                String contactEndDate = information.getContactEndDate();
                try {
                    Date date =  format.parse(contactEndDate);
                    long dateTime = date.getTime();
                    long Tdate  = dateTime - timeMillis;
                     /**15-30天发送邮件,每天在10点发一个邮件*/
                    if(Tdate < cron && Tdate > cron1){
                        String principalEmail = information.getPrincipalEmail();
                    }
                    /**7-15天发送邮件,每天在10点和16点发一个邮件*/
                    if(Tdate > cron2 && Tdate <= cron1){
                        String principalEmail = information.getPrincipalEmail();

                    }
                    /**0-7天发送邮件,每2小时发一次*/
                    if(Tdate <= cron2 && Tdate >= cron3){
                        String principalEmail = information.getPrincipalEmail();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

        }

        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}