package com.lee.productservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2021/4/7 15:34
 */
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    @Version
    private long version;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    private String name;
    private String spu;
    private String sku;
    private String brand;
    private List<String> category;
    private Double retail;
    private Double sale;
    private boolean enabled;
    private int inventory;
    private int views;
    private String mainImage;
    private List<String> detailImages;
    private String description;
    private float reviewRate;
    private int reviewCount;
    private Map<String, String> details;

    public Product() {
    }

    public Product(Date createTime, Date updateTime, String creatorId, String name, String spu, String sku, String brand, List<String> category, Double retail, Double sale, boolean enabled, int inventory, int views, String mainImage, List<String> detailImages, String description, float reviewRate, int reviewCount, Map<String, String> details) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.creatorId = creatorId;
        this.name = name;
        this.spu = spu;
        this.sku = sku;
        this.brand = brand;
        this.category = category;
        this.retail = retail;
        this.sale = sale;
        this.enabled = enabled;
        this.inventory = inventory;
        this.views = views;
        this.mainImage = mainImage;
        this.detailImages = detailImages;
        this.description = description;
        this.reviewRate = reviewRate;
        this.reviewCount = reviewCount;
        this.details = details;
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

    public String getSpu() {
        return spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public Double getRetail() {
        return retail;
    }

    public void setRetail(Double retail) {
        this.retail = retail;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<String> getDetailImages() {
        return detailImages;
    }

    public void setDetailImages(List<String> detailImages) {
        this.detailImages = detailImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(float reviewRate) {
        this.reviewRate = reviewRate;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    // TODO 查阅<<Effective Java>>对应用类型的get处理
    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creatorId='" + creatorId + '\'' +
                ", name='" + name + '\'' +
                ", spu='" + spu + '\'' +
                ", sku='" + sku + '\'' +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                ", retail=" + retail +
                ", sale=" + sale +
                ", enabled=" + enabled +
                ", inventory=" + inventory +
                ", views=" + views +
                ", mainImage='" + mainImage + '\'' +
                ", detailImages=" + detailImages +
                ", description='" + description + '\'' +
                ", reviewRate=" + reviewRate +
                ", reviewCount=" + reviewCount +
                ", details=" + details +
                '}';
    }
}
