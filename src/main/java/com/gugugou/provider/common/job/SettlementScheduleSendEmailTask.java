package com.gugugou.provider.common.job;

import com.gugugou.provider.common.until.SendEmail;
import com.gugugou.provider.common.until.TimeToStamp;
import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.provider.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 结算单发送短信的定时任务
 * @author: yuelitao
 * @date 2020/1/11 18:47
 */
@Component
@Configuration
@EnableScheduling
@Transactional
public class SettlementScheduleSendEmailTask implements SchedulingConfigurer {

    @Autowired
    private InformationService informationService;

    @Autowired
    private SendEmail sendEmail;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    //查询出所有的非过期的供应商(供应商状态:正常，即将过期，过期)
                    //这个方法其实就是查询的所有非过期状态的供应商
                    List<Information> informations = informationService.queryAllProviders();
                    //获取当前系统日期时间戳
                    Date nowTime = new Date();
                    for (Information information : informations) {
                        //获取该供应商的下一次结算时间
                        Date nextSettlementTime = information.getNextSettlementTime();

                        //时间格式转换(精确到日)
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String nextSettlementTimeStr = simpleDateFormat.format(nextSettlementTime);
                        String nowTimeStr = simpleDateFormat.format(nowTime);

                        //获取平台负责人邮件
                        String principalEmail = information.getPrincipalEmail();

                        try {
                            //下一次结算日期
                            long nextSettlementTimeL = TimeToStamp.timeToStamp(nextSettlementTimeStr);
                            long nowTimeL = TimeToStamp.timeToStamp(nowTimeStr);
                            if (nowTimeL == nextSettlementTimeL){
                                //到结算日期，发送邮件
                                sendEmail.sendMail(principalEmail,"供应商id为"+information.getId()+"结算日期到了","结算提醒");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.3 返回执行周期(Date)
                    logger.info("执行时间：{}", System.currentTimeMillis());
                    String cron = "0 59 23 * * ?";
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
