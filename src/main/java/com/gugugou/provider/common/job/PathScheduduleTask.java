package com.gugugou.provider.common.job;

import com.gugugou.provider.commodity.dao.PathDao;
import com.gugugou.provider.commodity.model.PathModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.until.TimeToStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: PathScheduduleTask
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/25 19:32
 */
@Component
@Configuration
@EnableScheduling
@Transactional
public class PathScheduduleTask implements SchedulingConfigurer {

    @Resource
    private PathDao pathDao;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    //修改路径状态
                    List<PathModel> pathModelList = pathDao.selectPathList();
                    PathModel pathModelUpdate = new PathModel();
                    long now = System.currentTimeMillis();
                    if (!pathModelList.isEmpty()) {
                        for (PathModel pathModel:pathModelList) {
                            if (!ProviderCentreConsts.INTEGER_ONE.equals(pathModel.getPathCloseOpen())) {
                                Long id = pathModel.getId();
                                String pathStartTime = pathModel.getPathStartTime();
                                String pathEndTime = pathModel.getPathEndTime();
                                try {
                                    long start = TimeToStamp.timeToStamp(pathStartTime);
                                    long end = TimeToStamp.timeToStamp(pathEndTime);
                                    if (now < start) {
                                        pathModelUpdate.setId(id);
                                        pathModelUpdate.setPathStatus(ProviderCentreConsts.INTEGER_TWO);
                                        pathDao.updatePath(pathModel);
                                    }else if (now >= start && now <= end) {
                                        pathModelUpdate.setId(id);
                                        pathModelUpdate.setPathStatus(ProviderCentreConsts.INTEGER_ZERO);
                                        pathDao.updatePath(pathModel);
                                    }else if(now > end) {
                                        pathModelUpdate.setId(id);
                                        pathModelUpdate.setPathStatus(ProviderCentreConsts.INTEGER_ONE);
                                        pathModelUpdate.setPathCloseOpen(ProviderCentreConsts.INTEGER_ONE);
                                        pathDao.updatePath(pathModel);
                                    }
                                } catch (ParseException e) {
                                    throw new RuntimeException("日期解析异常");
                                }
                            }
                        }
                    }
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.3 返回执行周期(Date)
                    logger.info("执行时间：{}", System.currentTimeMillis());
                    String cron = "0 0 0 * * ?";
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
