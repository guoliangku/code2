package com.example.base;

import java.util.Date;

public class BaseEntity {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新时间
     */
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
