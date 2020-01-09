package com.gugugou.provider.stream.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ShortVideo implements Serializable {

    /**主键id*/
    private Long id;

    /**当前页*/
    private Integer pageIndex;

    /**每页数据*/
    private Integer pageSize;

    /**短视频录制开始时间*/
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private String transcribeStartTime;

    /**短视频录制结束时间*/
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private String transcribeEndTime;

    /**短视频录制链接*/
    private String recordedLink;

    /**关联商品id*/
    private Long itemId;

    /**直播正常开始时间*/
    private Date normalStartTime;

    /**直播正常结束时间*/
    private Date normalEndTime;

    /**直播实际开始时间*/
    private Date actualStartTime;

    /**直播实际结束时间*/
    private Date actualEndTime;

    /**长视频的存储路径*/
    private String longVideoUrl;

    /**订单id*/
    private Long orderFormId;

    /**直播间id*/
    private Long directBroadcastingRoomId;

    /**排班间id*/
    private Long arrangeRoomId;

    /**短视频状态*/
    private int status;

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

    /**商品*/
    private String name;

}
