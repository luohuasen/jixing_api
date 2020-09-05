package com.jixing.cms.controller;

import com.jixing.cms.mapper.BannerMapper;
import com.jixing.cms.model.Banner;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerMapper bannerMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody Banner banner){
        bannerMapper.insertSelective(banner);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        bannerMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody Banner banner){
        bannerMapper.updateByPrimaryKeySelective(banner);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        return BaseResponse.success(banner);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",required = false, defaultValue = "20") Integer pageSize){
        int count = bannerMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<Banner> list = bannerMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
