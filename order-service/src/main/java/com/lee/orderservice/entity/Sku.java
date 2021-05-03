package com.lee.orderservice.entity;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 17:41
 */
public class Sku {
    /**
     * 商品skuID
     */
    private String skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品实际价格,单位:元
     */
    private Double skuSale;
    /**
     * 商品数量
     */
    private int cartNumber;
    /**
     * 该商品总金额,单位:元
     */
    private Double cartSum;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Double getSkuSale() {
        return skuSale;
    }

    public void setSkuSale(Double skuSale) {
        this.skuSale = skuSale;
    }

    public Double getCartSum() {
        return cartSum;
    }

    public void setCartSum(Double cartSum) {
        this.cartSum = cartSum;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuId='" + skuId + '\'' +
                ", skuName='" + skuName + '\'' +
                ", skuSale=" + skuSale +
                ", cartNumber=" + cartNumber +
                ", cartSum=" + cartSum +
                '}';
    }
}