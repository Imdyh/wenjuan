package com.wenjuan.entity;

import java.util.UUID;

/**
 * @author wxt.dyh
 * @version V1.0
 * @date 2020/2/6/0006 13:53:39
 */
public class BaseEntity {

    protected String id;  //唯一标识

    protected Integer flag;   //是否有效 0：无效，1：有效

    protected Integer is_deleted; //是否被删除 0:未删除，1：已删除

    protected boolean isNewRecord = false;  //是否是新记录，如果新记录就生成id

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }
}
