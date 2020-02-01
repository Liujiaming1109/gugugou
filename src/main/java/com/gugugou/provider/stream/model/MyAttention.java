package com.gugugou.provider.stream.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的关注model
 * @author: yuelitao
 * @date 2020/1/30 22:55
 */
@Data
public class MyAttention implements Serializable{

    /** 主键id */
    private Long id ;
    /** 用户id */
    private Long userId ;
    /** 直播间id */
    private Long directBroadcastingRoomId ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updatedTime ;
    /**逻辑删除*/
    private Integer removed;
}
