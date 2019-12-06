package com.gugugou.provider.common.until;

import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: BrandTimedTask
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/6 10:44
 */
@Component
@Configuration
@EnableScheduling
@Transactional
public class BrandScheduleTask implements SchedulingConfigurer {

    @Resource
    private BrandDao brandDao;


    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        /**
         * 修改资质到期状态
         */
        scheduledTaskRegistrar.addTriggerTask(
        //1.添加任务内容(Runnable)
        () -> {
            List<BrandModel> brandModelList = brandDao.selectAptitudeList();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long timeMillis = System.currentTimeMillis();
            long cron = DaysToMillis.daysToMillis(30L);
            brandModelList.parallelStream().forEach(brandModel -> {
                    String trademarkEndDate = brandModel.getTrademarkEndDate();
                    try {
                        Date date = format.parse(trademarkEndDate);
                        long dateTime = date.getTime();
                        boolean flag = dateTime - timeMillis < cron ? true : false;
                        if (flag) {
                            brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_ONE);
                            brandDao.updateAptitude(brandModel);
                        }
                        if (dateTime < timeMillis) {
                            brandModel.setTrademarkStatus(ProviderCentreConsts.TRADEMARK_STATUS_TWO);
                            brandDao.updateAptitude(brandModel);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
        },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.3 返回执行周期(Date)
                    String cron = "0 0 0 * * ?";
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
