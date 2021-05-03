package com.lee.fileservice.controller;

import com.lee.fileservice.fastdfs.FastDFSClient;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/18 20:13
 */
@Slf4j
@RestController
public class DeleteController {

    @DeleteMapping("/file")
    public int delete (@RequestParam("filePath") String filePath) throws Exception {
        try {
            deleteFile(filePath);
            log.info("Delete file " + filePath + " succeed");
            return 0;
        } catch (IOException | MyException e) {
            log.error("Delete file " + filePath + " failed");
            e.printStackTrace();
            throw new Exception("删除文件错误");
        }
    }


    private void deleteFile(String fileId) throws IOException, MyException {
        FastDFSClient.deleteFile(fileId);
    }
}
