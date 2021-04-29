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
@Document(collection = "sku")
public class Sku {
    @Id
    private String id;
    @Version
    private long version;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    private String name;
    private String model;
    private String spu;
    // 商品编号
    private String slug;
    private String weight;
    private String origin;
    private String color;
    private List<String> category;

    private Double retail;
    private Double sale;
    private boolean enabled;
    private int inventory;
    private int views;
    private String mainImage;
    private List<String> detailImages;
    private float reviewRate;
    private int reviewCount;
    private Map<String, String> details;

    public Sku() {
    }

    public Sku(long version, Date createTime, Date updateTime, String creatorId, String name, String model, String spu, String slug, String weight, String origin, String color, List<String> category, Double retail, Double sale, boolean enabled, int inventory, int views, String mainImage, List<String> detailImages, float reviewRate, int reviewCount, Map<String, String> details) {
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.creatorId = creatorId;
        this.name = name;
        this.model = model;
        this.spu = spu;
        this.slug = slug;
        this.weight = weight;
        this.origin = origin;
        this.color = color;
        this.category = category;
        this.retail = retail;
        this.sale = sale;
        this.enabled = enabled;
        this.inventory = inventory;
        this.views = views;
        this.mainImage = mainImage;
        this.detailImages = detailImages;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpu() {
        return spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creatorId='" + creatorId + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", spu='" + spu + '\'' +
                ", slug='" + slug + '\'' +
                ", weight='" + weight + '\'' +
                ", origin='" + origin + '\'' +
                ", color='" + color + '\'' +
                ", category=" + category +
                ", retail=" + retail +
                ", sale=" + sale +
                ", enabled=" + enabled +
                ", inventory=" + inventory +
                ", views=" + views +
                ", mainImage='" + mainImage + '\'' +
                ", detailImages=" + detailImages +
                ", reviewRate=" + reviewRate +
                ", reviewCount=" + reviewCount +
                ", details=" + details +
                '}';
    }
}
