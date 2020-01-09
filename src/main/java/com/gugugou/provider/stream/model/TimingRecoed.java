package com.gugugou.provider.stream.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class TimingRecoed implements Serializable {

    /**主键id*/
    private Long id;

    /**发送邮件的时间*/
    private Date sendEmailTime;

    /**发送内容*/
    private String sendContent;

    /**供应商名称*/
    private String providerName;

    /**品牌名称*/
    private String brandName;

    /**接受人的邮件*/
    private String recipientEmail;

    /**接收人的名字*/
    private String recipientName;

    /**类型*/
    private int type;

    /**创建人*/
    private String createdBy;

    /**创建时间*/
    private Date createdTime;

    /**逻辑删除*/
    private int removed;
}
