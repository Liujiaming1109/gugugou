package com.gugugou.provider.stream.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.swing.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date anchorStartDate;

    /**终止时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date anchorEndDate;

    /**直播间图片*/
    private String anchorPicture;

    /**直播间位置*/
    private String anchorPlace;

    /**直播间标签*/
    private String anchorLabel;

    /**直播间主播名称*/
    private String anchorPeopleName;

    /**排班直播间的状态*/
    private int streamingStatus;

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

    /**排班表与商品表的中间表的*/
    private List<ArrangeAndSku> arrangeAndSku;
}
