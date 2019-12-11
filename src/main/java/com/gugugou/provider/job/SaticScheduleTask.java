package com.gugugou.provider.job;

import com.gugugou.provider.common.until.DaysToMillis;
import com.gugugou.provider.provider.controller.InformationController;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Information;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
public class SaticScheduleTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private InformationDao informationDao;
    /**发送邮件的实现类*/
    @Resource
    private InformationController informationController;

    //添加定时任务
    //每天十点定时跑一次
    @Scheduled(cron = "0 0 10 * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("执行时间:configureTasks:{}",format.format(new Date()));
        List<Information> informations = informationDao.findAllProvider();
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
                        informationController.sendEmail(principalEmail);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }

    }


    @Scheduled(cron = "0 0 10,16 * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks1() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("执行时间:configureTasks1:{}",format.format(new Date()));
        List<Information> informations = informationDao.findAllProvider();

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

                /**7-15天发送邮件,每天在10点和16点发一个邮件*/
                if(Tdate > cron2 && Tdate <= cron1){
                    String principalEmail = information.getPrincipalEmail();
                    informationController.sendEmail(principalEmail);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

    }

    @Scheduled(cron = "0 0 0/2 * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks2() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("执行时间:configureTasks2:{}",format.format(new Date()));
        List<Information> informations = informationDao.findAllProvider();
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

                /**0-7天发送邮件,每2小时发一次*/
                if(Tdate <= cron2 && Tdate >= cron3){
                    String principalEmail = information.getPrincipalEmail();
                    informationController.sendEmail(principalEmail);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

    }
}