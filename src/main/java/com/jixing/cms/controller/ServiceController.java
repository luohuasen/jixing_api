package com.jixing.cms.controller;

import com.jixing.cms.mapper.ServiceMapper;
import com.jixing.cms.model.Service;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceMapper serviceMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody Service service){
        serviceMapper.insertSelective(service);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        serviceMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody Service service){
        serviceMapper.updateByPrimaryKeySelective(service);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        Service service = serviceMapper.selectByPrimaryKey(id);
        return BaseResponse.success(service);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        int count = serviceMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<Service> list = serviceMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
