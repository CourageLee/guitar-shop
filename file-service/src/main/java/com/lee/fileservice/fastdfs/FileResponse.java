package com.lee.fileservice.fastdfs;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/29 12:06
 */
public class FileResponse {
    private String trackUrl;
    private String filePath;

    public FileResponse(String trackUrl, String filePath) {
        this.trackUrl = trackUrl;
        this.filePath = filePath;
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
                "trackUrl='" + trackUrl + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
