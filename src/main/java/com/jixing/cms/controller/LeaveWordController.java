package com.jixing.cms.controller;

import com.jixing.cms.mapper.LeaveWordMapper;
import com.jixing.cms.model.LeaveWord;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("leaveWord")
public class LeaveWordController {
    @Autowired
    private LeaveWordMapper leaveWordMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody LeaveWord word){
        leaveWordMapper.insertSelective(word);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        leaveWordMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody LeaveWord word){
        leaveWordMapper.updateByPrimaryKeySelective(word);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        LeaveWord config = leaveWordMapper.selectByPrimaryKey(id);
        return BaseResponse.success(config);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",required = false, defaultValue = "20") Integer pageSize){
        int count = leaveWordMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<LeaveWord> list = leaveWordMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
