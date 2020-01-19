package com.gugugou.provider.job;

import com.gugugou.provider.common.until.DaysToMillis;
import com.gugugou.provider.provider.controller.InformationController;
import com.gugugou.provider.provider.dao.InformationDao;
import com.gugugou.provider.provider.model.Information;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Initiator implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private InformationDao informationDao;

    @Resource
    private InformationController informationController;

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("你好,我是防止宕机丢失发送邮件的启动器");

       /* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("执行时间:configureTasks:{}",format.format(new Date()));
        List<Information> informations = informationDao.findAllProvider();
        long timeMillis = System.currentTimeMillis();
        long cron = DaysToMillis.daysToMillis(30L);
        long cron4 = DaysToMillis.daysToMillis(0L);
        for (Information information: informations) {
            String contactEndDate = information.getContactEndDate();
            if(!contactEndDate.isEmpty()){
                try {
                    Date date =  format.parse(contactEndDate);
                    long dateTime = date.getTime();
                    long Tdate  = dateTime - timeMillis;
                    *//**合同30-0天发送邮件*//*
                    if(Tdate <= cron && Tdate >= cron4){
                        String principalEmail = information.getPrincipalEmail();
                        informationController.sendEmail(principalEmail);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
*/


    }
}
