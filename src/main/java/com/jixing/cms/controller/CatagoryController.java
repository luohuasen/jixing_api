package com.jixing.cms.controller;

import com.jixing.cms.mapper.CatagoryMapper;
import com.jixing.cms.mapper.SubCatagoryMapper;
import com.jixing.cms.model.Catagory;
import com.jixing.cms.model.SubCatagory;
import com.jixing.cms.vo.CatagoryItem;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("catagory")
public class CatagoryController {
    @Autowired
    private CatagoryMapper catagoryMapper;
    @Autowired
    private SubCatagoryMapper subCatagoryMapper;

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
        List<CatagoryItem> list = catagoryMapper.list();
        BasePageResponse response = BasePageResponse.success(list, 0, 0);
        return response;
    }

    @RequestMapping("list")
    @ResponseBody
    public BasePageResponse list(){
        List<CatagoryItem> list = catagoryMapper.list();
        BasePageResponse response = BasePageResponse.success(list, 0, 0);
        List<SubCatagory> subCatagoryList = subCatagoryMapper.listAll();
        Map<Integer, CatagoryItem> catagoryItemMap = new HashMap<>();
        for(CatagoryItem item : list){
            catagoryItemMap.put(item.getId(), item);
        }

        for(SubCatagory subCatagory : subCatagoryList){
            Integer catagoryId = subCatagory.getCatagoryId();
            if(!catagoryItemMap.containsKey(catagoryId)){
                continue;
            }

            CatagoryItem item = catagoryItemMap.get(catagoryId);
            item.addSubCataGory(subCatagory);
        }
        return response;
    }
}
