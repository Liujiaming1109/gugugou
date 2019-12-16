package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class StreamingComment implements Serializable {
    /**主键id*/
    private Long id;
    /**长视频id*/
    private Long anchorRoomId;
    /**评论人id*/
    private Long commentId;
    /**评论人名称*/
    private String commentName;
    /**评论内容*/
    private String commentContent;
    /**评论时间*/
    private Date commentTime;
    /**评论状态*/
    private int status;
    /**禁言时间*/
    private Date saymsgTime;
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
