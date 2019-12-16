package com.gugugou.provider.stream.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ArrangeStreaming implements Serializable {

    /**主键id*/
    private Long id;
    /**直播间id*/
    private Long directBroadcastingRoomId;
    /**直播间名称*/
    private String anchorName;
    /**直播间标题*/
    private String anchorTitle;
    /**起始时间*/
    @JsonProperty("yyyy-MM-dd")
    private Date anchorStartDate;
    /**终止时间*/
    private Date anchorEndDate;
    /**直播间图片*/
    private String anchorPicture;
    /**直播间位置*/
    private String anchorPlace;
    /**直播间主播名称*/
    private String anchorPeopleName;
    /**创建人*/
    private String createdBy;
    /**创建时间*/
    private Date createdTime;
    /**更新人*/
    private String updatedBy;
    /**更新时间*/
    private Date updatedTime;
    /**逻辑删除*/
    private int removed;
}
