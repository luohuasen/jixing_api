package com.jixing.cms.controller;

import com.jixing.cms.mapper.ConfigMapper;
import com.jixing.cms.model.Config;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("config")
public class ConfigController {
    @Autowired
    private ConfigMapper configMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody Config config){
        configMapper.insertSelective(config);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        configMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody Config banner){
        configMapper.updateByPrimaryKeySelective(banner);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        Config config = configMapper.selectByPrimaryKey(id);
        return BaseResponse.success(config);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        int count = configMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<Config> list = configMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
