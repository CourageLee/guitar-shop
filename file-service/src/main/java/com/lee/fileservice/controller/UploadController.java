package com.lee.fileservice.controller;

import com.lee.fileservice.fastdfs.FastDFSClient;
import com.lee.fileservice.fastdfs.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@Slf4j
public class UploadController {
    @GetMapping("/test")
    public String test() {
        return "Connect success";
    }

    @PostMapping("/file")
    public String singleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("文件不能为空");
        }
        String path = null;
        try {
            // Get the file and save it somewhere
            path=saveFile(file);
        } catch (Exception e) {
            log.error("upload file failed",e);
            throw new Exception("上传文件错误");
        }
        return path;
    }

    /**
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath={};
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();

        int len1 = inputStream.available();
        file_buff = new byte[len1];
        inputStream.read(file_buff);
        inputStream.close();


        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            log.error("upload file Exception!",e);
        }
        if (fileAbsolutePath==null) {
            log.error("upload file failed,please upload again!");
        }
        return fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
    }
}