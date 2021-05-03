package com.lee.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/2 10:35
 */
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    @Version
    private long version;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 订单商品
     */
    private List<Sku> skus;
    /**
     * 订单状态
     */
    private OrderStatus status;
    /**
     * 订单总金额,单位:元
     */
    private Double orderRetail;
    /**
     * 订单实际金额,单位:元
     */
    private Double orderSale;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getOrderRetail() {
        return orderRetail;
    }

    public void setOrderRetail(Double orderRetail) {
        this.orderRetail = orderRetail;
    }

    public Double getOrderSale() {
        return orderSale;
    }

    public void setOrderSale(Double orderSale) {
        this.orderSale = orderSale;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creatorId='" + creatorId + '\'' +
                ", username='" + username + '\'' +
                ", skus=" + skus +
                ", status=" + status +
                ", orderRetail=" + orderRetail +
                ", orderSale=" + orderSale +
                '}';
    }
}
