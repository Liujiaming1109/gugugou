package com.gugugou.provider.common.until;

import com.gugugou.provider.aptitude.DTO.SelectListDTO;
import com.gugugou.provider.aptitude.dao.BrandDao;
import com.gugugou.provider.aptitude.model.BrandModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import java.util.concurrent.TimeUnit;

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
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SendEmail sendEmail;

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
            List<SelectListDTO> selectListDTOList = brandDao.selectList();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long timeMillis = System.currentTimeMillis();
            long cron = DaysToMillis.daysToMillis(30L);
            long cron1 = DaysToMillis.daysToMillis(15L);
            long cron2 = DaysToMillis.daysToMillis(7L);
            Long cron3 = DaysToMillis.daysToMillis(3L);
            if (!selectListDTOList.isEmpty()) {
                selectListDTOList.parallelStream().forEach(selectListDTO -> {
                    List<BrandModel> brandModelList = selectListDTO.getBrandModelList();
                    String principalEmail = selectListDTO.getPrincipalEmail();
                    Integer id = selectListDTO.getId();
                    for (BrandModel brandModel:brandModelList) {
                        String trademarkEndDate = brandModel.getTrademarkEndDate();
                        Date date = null;
                        Integer count;
                        try {
                            date = format.parse(trademarkEndDate);
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
                            long T = dateTime - timeMillis;
                            String s = stringRedisTemplate.opsForValue().get(id + "count");
                            if (s == null) {
                                if (T > cron1 && T<= cron) {
                                    sendEmail.sendMail(principalEmail,"你好，我就测试一下","测试");
                                    count = 1;
                                    stringRedisTemplate.opsForValue().set(id+"count", String.valueOf(count));
                                }
                            }
                            if (ProviderCentreConsts.INTEGER_ONE.equals(s)) {
                                if (T > cron2 && T<= cron1) {
                                    sendEmail.sendMail(principalEmail,"你好，我就测试一下","测试");
                                    count = 2;
                                    stringRedisTemplate.opsForValue().set(id+"count", String.valueOf(count));
                                }
                            }
                            if (ProviderCentreConsts.INTEGER_TWO.equals(s)) {
                                if (T > cron3 && T<= cron2) {
                                    sendEmail.sendMail(principalEmail,"你好，我就测试一下","测试");
                                    count = 3;
                                    stringRedisTemplate.opsForValue().set(id+"count", String.valueOf(count));
                                }
                            }
                            if (ProviderCentreConsts.INTEGER_THREE.equals(s)) {
                                if (T >= ProviderCentreConsts.INTEGER_ZERO && T<= cron3) {
                                    sendEmail.sendMail(principalEmail,"你好，我就测试一下","测试");
                                    count = 4;
                                    stringRedisTemplate.opsForValue().set(id+"count", String.valueOf(count));
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.3 返回执行周期(Date)
                    String cron = "0 0 0,10 * * ?";
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
