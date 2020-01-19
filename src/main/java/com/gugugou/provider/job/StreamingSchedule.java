package com.gugugou.provider.job;

import com.gugugou.provider.provider.model.Information;
import com.gugugou.provider.stream.dao.StreamingDao;
import com.gugugou.provider.stream.model.ArrangeStreaming;
import com.gugugou.provider.stream.service.StreamingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *
 * 定时刷新排班直播间的状态
 * */

@Component
@Configuration
public class StreamingSchedule {

    @Resource
    private StreamingDao streamingDao;

    @Resource
    private StreamingService streamingService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Scheduled(cron = "0 */1 * * * ?")
    private void configureTasks() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("执行时间:configureTasks:{}", format.format(new Date()));

        /*List<ArrangeStreaming> arrangeList = streamingDao.findArrangeLists();
        long timeMillis = System.currentTimeMillis();
        for (ArrangeStreaming information : arrangeList) {
            int streamingStatus = information.getStreamingStatus();
            Date anchorStartDate = information.getAnchorStartDate();
            Date anchorEndDate = information.getAnchorEndDate();


            long dateStartTime = anchorStartDate.getTime();
            long dateEndTime = anchorEndDate.getTime();
            long TSdate = dateStartTime - timeMillis;
            long TEdate = dateEndTime - timeMillis;
            *//**等待*//*
            if (TSdate > 0) {
                information.setStreamingStatus(1);
                streamingService.updateStreamingStatus(information);
                streamingDao.findArrangeLists();
            }
            *//**在线*//*
            if (TSdate <= 0 && TEdate >= 0) {
                information.setStreamingStatus(0);
                streamingService.updateStreamingStatus(information);
                streamingDao.findArrangeLists();
            }
            *//**过期*//*
            if (TEdate < 0) {
                information.setStreamingStatus(2);
                streamingService.updateStreamingStatus(information);
                streamingDao.findArrangeLists();
            }
        }*/
    }
}
