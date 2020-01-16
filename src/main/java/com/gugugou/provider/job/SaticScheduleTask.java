package com.gugugou.provider.job;

import com.gugugou.provider.common.until.DaysToMillis;
import com.gugugou.provider.common.until.SendEmail;
import com.gugugou.provider.provider.controller.InformationController;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.stream.dao.StreamingDao;
import com.gugugou.provider.stream.model.TimingRecoed;
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

    @Resource
    private StreamingDao streamingDao;

    /**发送邮件的工具*/
    @Resource
    private SendEmail sendEmail;

    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    //添加定时任务
    //每天十点定时跑一次
    /**在合同到期前30天发送*/
    @Scheduled(cron = "0 0 10 * * ?")
    private void configureTasks() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("执行时间:configureTasks:{}",format.format(new Date()));
        TimingRecoed timing = new TimingRecoed();
        List<Information> informations = informationDao.findAllProvider();
        long timeMillis = System.currentTimeMillis();
        long cron = DaysToMillis.daysToMillis(30L);
        long cron1 = DaysToMillis.daysToMillis(15L);
        long cron2 = DaysToMillis.daysToMillis(7L);
        long cron3 = DaysToMillis.daysToMillis(3L);
        long cron4 = DaysToMillis.daysToMillis(0L);
        for (Information information: informations) {
                String contactEndDate = information.getContactEndDate();
                if(!contactEndDate.isEmpty()){
                    try {
                        Date date =  format.parse(contactEndDate);
                        long dateTime = date.getTime();
                        long Tdate  = dateTime - timeMillis;
                        /**合同前30天发送邮件*/
                        if(Tdate == cron){
                            String principalEmail = information.getPrincipalEmail();
                            sendEmail.sendMail(principalEmail,"尊敬的"+information.getProviderName()+"您好,合同还有30天即将到期,请及时续约","咕咕购合同即将到期");
                            timing.setCreatedTime(new Date());
                            timing.setSendEmailTime(new Date());
                            timing.setProviderName(information.getProviderName());
                            timing.setRecipientEmail(information.getPrincipalEmail());
                            timing.setRecipientName(information.getPlatformPrincipal());
                            streamingDao.addTimingRecord(timing);
                        }
                        /**合同到期前15天发送邮件*/
                        if( Tdate == cron1){
                            String principalEmail = information.getPrincipalEmail();
                            sendEmail.sendMail(principalEmail,"尊敬的"+information.getProviderName()+"您好,合同还有15天即将到期,请及时续约","咕咕购合同即将到期");
                            timing.setCreatedTime(new Date());
                            timing.setSendEmailTime(new Date());
                            timing.setProviderName(information.getProviderName());
                            timing.setSendContent("你好,合同即将到期,请及时续约");
                            timing.setRecipientEmail(information.getPrincipalEmail());
                            timing.setRecipientName(information.getPlatformPrincipal());
                            streamingDao.addTimingRecord(timing);
                        }
                        /**合同前7天发送邮件*/
                        if(Tdate == cron2){
                            String principalEmail = information.getPrincipalEmail();
                            sendEmail.sendMail(principalEmail,"尊敬的"+information.getProviderName()+"您好,合同还有7天即将到期,请及时续约","咕咕购合同即将到期");
                            timing.setCreatedTime(new Date());
                            timing.setSendEmailTime(new Date());
                            timing.setProviderName(information.getProviderName());
                            timing.setSendContent("你好,合同即将到期,请及时续约");
                            timing.setRecipientEmail(information.getPrincipalEmail());
                            timing.setRecipientName(information.getPlatformPrincipal());
                            streamingDao.addTimingRecord(timing);
                        }
                        /**合同前3天发送邮件*/
                        if(Tdate == cron3){
                            String principalEmail = information.getPrincipalEmail();
                            sendEmail.sendMail(principalEmail,"尊敬的"+information.getProviderName()+"您好,合同还有三天即将到期,请及时续约","咕咕购合同即将到期");
                            timing.setCreatedTime(new Date());
                            timing.setSendEmailTime(new Date());
                            timing.setProviderName(information.getProviderName());
                            timing.setSendContent("你好,合同即将到期,请及时续约");
                            timing.setRecipientEmail(information.getPrincipalEmail());
                            timing.setRecipientName(information.getPlatformPrincipal());
                            streamingDao.addTimingRecord(timing);
                        }
                        /**合同过期当天发送邮件*/
                        if(Tdate == cron4){
                            String principalEmail = information.getPrincipalEmail();
                            sendEmail.sendMail(principalEmail,"尊敬的"+information.getProviderName()+"您好,您的合同明天即将过期,请及时续约","咕咕购合同即将到期");
                            timing.setCreatedTime(new Date());
                            timing.setSendEmailTime(new Date());
                            timing.setProviderName(information.getProviderName());
                            timing.setSendContent("你好,合同即将到期,请及时续约");
                            timing.setRecipientEmail(information.getPrincipalEmail());
                            timing.setRecipientName(information.getPlatformPrincipal());
                            streamingDao.addTimingRecord(timing);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                  }
             }
    }
}