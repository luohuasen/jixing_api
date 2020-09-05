package com.jixing.cms.controller;

import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("upload")
public class UploadController {
    @Value("${uploadPath}")
    private String uploadPath;
    @Value("${serverUrl}")
    private String serverUrl;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    @RequestMapping("image")
    @ResponseBody
    public BaseResponse image(@RequestParam("file") MultipartFile file){
        String dateFormat = formatter.format(LocalDate.now());
        String uuid = UUID.randomUUID().toString().replace("-","");
        String filename = file.getOriginalFilename();
        String extName = filename.substring(filename.lastIndexOf("."));
        String sourceId = dateFormat + "/" + uuid + extName;
        String savePath = uploadPath + sourceId;
        try {
            file.transferTo(new File(savePath));
        } catch (Exception e) {
            log.error("save Image error {}", e);
            return BaseResponse.fail("save Image error");
        }
        String publicPath = serverUrl + "uploads/" + sourceId;
        return BaseResponse.success(publicPath);
    }
}
