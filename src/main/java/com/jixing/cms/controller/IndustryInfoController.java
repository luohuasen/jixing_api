package com.jixing.cms.controller;

import com.jixing.cms.mapper.IndustryInfoMapper;
import com.jixing.cms.model.IndustryInfo;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("industryInfo")
public class IndustryInfoController {
    @Autowired
    private IndustryInfoMapper industryInfoMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody IndustryInfo industryInfo){
        industryInfoMapper.insertSelective(industryInfo);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        industryInfoMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody IndustryInfo industryInfo){
        industryInfoMapper.updateByPrimaryKeySelective(industryInfo);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        IndustryInfo config = industryInfoMapper.selectByPrimaryKey(id);
        return BaseResponse.success(config);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",required = false, defaultValue = "20") Integer pageSize){
        int count = industryInfoMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<IndustryInfo> list = industryInfoMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
