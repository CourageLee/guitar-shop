package com.lee.fileservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.StorageClient1;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.annotation.Resource;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/18 20:13
 */
@Slf4j
public class DeleteController {
    @Resource
    StorageClient1 storageClient1;

    @DeleteMapping("/file")


    private int deleteFile(String fileId) {
        try {
            int result = storageClient1.delete_file1(fileId);
            return result;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }
}
