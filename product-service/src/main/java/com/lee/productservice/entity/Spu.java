package com.lee.productservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/22 15:47
 */
@Document(collection = "spu")
public class Spu {
    @Id
    private String id;
    @Version
    private long version;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    private String name;
    private String brand;
    /**
     * spu详细描述信息，以图片形式保存，此处保存图片的url(不包含host)
     */
    private List<FileResponse> description;
    /**
     * 是否可用，默认为false
     */
    private boolean enabled;

    public Spu() {
    }

    public Spu(long version, Date createTime, Date updateTime, String creatorId, String name, String brand, boolean enabled) {
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.creatorId = creatorId;
        this.name = name;
        this.brand = brand;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<FileResponse> getDescription() {
        return description;
    }

    public void setDescription(List<FileResponse> description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Spu{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creatorId='" + creatorId + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description=" + description +
                ", enabled=" + enabled +
                '}';
    }
}
