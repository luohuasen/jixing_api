package com.jixing.cms.controller;

import com.jixing.cms.mapper.SubCatagoryMapper;
import com.jixing.cms.model.SubCatagory;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("subCatagory")
public class SubCatagoryController {
    @Autowired
    private SubCatagoryMapper subCatagoryMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody SubCatagory config){
        subCatagoryMapper.insertSelective(config);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        subCatagoryMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody SubCatagory banner){
        subCatagoryMapper.updateByPrimaryKeySelective(banner);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        SubCatagory config = subCatagoryMapper.selectByPrimaryKey(id);
        return BaseResponse.success(config);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam("cataId") Integer cataId){
        List<SubCatagory> list = subCatagoryMapper.list(cataId);
        BasePageResponse response = BasePageResponse.success(list, 0, 0);
        return response;
    }
}
