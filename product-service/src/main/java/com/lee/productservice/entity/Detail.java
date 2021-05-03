package com.lee.productservice.entity;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/30 14:54
 */
public class Detail {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
