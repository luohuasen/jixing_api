package com.jixing.cms.controller;

import com.jixing.cms.mapper.WorkMapper;
import com.jixing.cms.model.Work;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("work")
public class WorkController {
    @Autowired
    private WorkMapper workMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody Work work){
        workMapper.insertSelective(work);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        workMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody Work work){
        workMapper.updateByPrimaryKeySelective(work);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        Work work = workMapper.selectByPrimaryKey(id);
        return BaseResponse.success(work);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",required = false, defaultValue = "20") Integer pageSize){

        BasePageResponse response = null;
        int count = workMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<Work> list = workMapper.list(pageIndex, pageSize);

        response = BasePageResponse.success(list, count, pageSum);
        log.info("delete response= " + response);
        return response;
    }
}
