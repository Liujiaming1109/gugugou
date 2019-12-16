package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ShortVideo implements Serializable {

    /**主键id*/
    private Long id;
    /**长直播id*/
    private Long longLiveStreamingId;
    /**录制开始时间*/
    private Date transcribeStartTime;
    /**录制结束时间*/
    private Date transcribeEndTime;
    /**录制链接*/
    private String recordedLink;
    /**关联商品id*/
    private Long commodityId;
    /**订单id*/
    private Long orderFormId;
    /**创建人*/
    private String createdBy;
    /**创建时间*/
    private Date createdTime;
    /**修改人*/
    private String updatedBy;
    /**修改时间*/
    private Date updatedTime;
    /**逻辑删除*/
    private int removed;
}
