package com.jixing.cms.controller;

import com.jixing.cms.mapper.CatagoryMapper;
import com.jixing.cms.model.Catagory;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("catagory")
public class CatagoryController {
    @Autowired
    private CatagoryMapper catagoryMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody Catagory config){
        catagoryMapper.insertSelective(config);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        catagoryMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody Catagory banner){
        catagoryMapper.updateByPrimaryKeySelective(banner);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        Catagory config = catagoryMapper.selectByPrimaryKey(id);
        return BaseResponse.success(config);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(){
        List<Catagory> list = catagoryMapper.list();
        BasePageResponse response = BasePageResponse.success(list, 0, 0);
        return response;
    }
}
