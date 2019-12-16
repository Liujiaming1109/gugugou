package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class LongVideo implements Serializable {
    /**主键id*/
    private Long id;
    /**直播间外键id*/
    private Long directBroadcastingRoomId;
    /**开始时间*/
    private Date startDate;
    /**结束时间*/
    private Date endDate;
    /**存储路径*/
    private String storagePath;
    /**直播商品的id*/
    private Long liveStreamingCommodityId;
    /**评论表外键id*/
    private Long commentId;
    /**点赞总量*/
    private Integer likeNum;
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
