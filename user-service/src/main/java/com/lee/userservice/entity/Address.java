package com.lee.userservice.entity;

/**
 * 收货地址
 * @author Lee
 * @version 1.0
 * @date 2021/3/26 21:57
 */
public class Address {
    private Long id;
    private Long userId;
    private int provinceId;
    private int cityId;
    private int boroughId;
    private int streetId;
    private String fullAddress;
    private String consignee;
    private String phone;
    private boolean defaultAddr;

    public Address() {
    }

    public Address(Long id, Long userId, int provinceId, int cityId, int boroughId, int streetId, String fullAddress, String consignee, String phone, boolean defaultAddr) {
        this.id = id;
        this.userId = userId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.boroughId = boroughId;
        this.streetId = streetId;
        this.fullAddress = fullAddress;
        this.consignee = consignee;
        this.phone = phone;
        this.defaultAddr = defaultAddr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getBoroughId() {
        return boroughId;
    }

    public void setBoroughId(int boroughId) {
        this.boroughId = boroughId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(boolean defaultAddr) {
        this.defaultAddr = defaultAddr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", boroughId=" + boroughId +
                ", streetId=" + streetId +
                ", fullAddress='" + fullAddress + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", defaultAddr=" + defaultAddr +
                '}';
    }
}
