package com.jixing.cms.controller;

import com.jixing.cms.mapper.ProductCatagoryMapper;
import com.jixing.cms.model.ProductCatagoryKey;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("productCatagory")
public class ProductCatagoryController {
    @Autowired
    private ProductCatagoryMapper productCatagoryMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody ProductCatagoryKey key){
        productCatagoryMapper.insert(key);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestBody ProductCatagoryKey key){
        productCatagoryMapper.deleteByPrimaryKey(key);
        return BaseResponse.success(null);
    }
}
