package com.jixing.cms.controller;

import com.jixing.cms.mapper.ProductMapper;
import com.jixing.cms.model.Banner;
import com.jixing.cms.model.Product;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody Banner banner){
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody Banner banner){
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        return BaseResponse.success(null);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        int count = productMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<Product> list = productMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
