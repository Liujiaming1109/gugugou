package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Streaming implements Serializable {

    /**主键*/
    private Long id;
    /**直播间名称*/
    private String  anchorName;
    /**直播间描述*/
    private String anchorDescribe;
    /**服务器*/
    private String anchorServer;
    /**串流秘钥*/
    private String crossfireKey;
    /**是否在线*/
    private Integer isOnLine;
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
