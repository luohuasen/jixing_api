package com.jixing.cms.controller;

import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("upload")
public class UploadController {
    @RequestMapping("image")
    @ResponseBody
    public BaseResponse image(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        return BaseResponse.success(null);
    }
}
