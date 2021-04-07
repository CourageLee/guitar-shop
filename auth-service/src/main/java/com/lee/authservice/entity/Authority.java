package com.lee.authservice.entity;

import java.util.Date;

/**
 * @author Lee
 * @date 2021/3/24 14:00
 */
public class Authority {
    private Long id;
    private String authorityCode;
    private String name;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authorityCode='" + authorityCode + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
