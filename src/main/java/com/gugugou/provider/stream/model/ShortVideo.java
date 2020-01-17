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

    /**关联商品id*/
    private Long itemId;

    /**正常开始时间*/
    private Date normalStartTime;

    /**正常结束时间*/
    private Date normalEndTime;

    /**实际开始时间*/
    private Date actualStartTime;

    /**实际结束时间*/
    private Date actualEndTime;

    /**长视频的存储路径*/
    private String videoUrl;

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

    /**类型*/
    private int type;

    /**短视频标题*/
    private String streamingTitle;

}
