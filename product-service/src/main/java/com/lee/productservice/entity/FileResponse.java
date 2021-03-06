package com.lee.productservice.entity;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/29 12:06
 */
public class FileResponse {
    private String name;
    private String trackUrl;
    private String filePath;

    public FileResponse(String name, String trackUrl, String filePath) {
        this.name = name;
        this.trackUrl = trackUrl;
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "name='" + name + '\'' +
                ", trackUrl='" + trackUrl + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
