package com.jixing.cms.controller;

import com.jixing.cms.mapper.ProductInfoMapper;
import com.jixing.cms.model.ProductInfo;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("add")
    @ResponseBody
    BaseResponse add(@RequestBody ProductInfo config){
        productInfoMapper.insertSelective(config);
        return BaseResponse.success(null);
    }

    @RequestMapping("delete")
    @ResponseBody
    BaseResponse delete(@RequestParam("id") Integer id){
        productInfoMapper.deleteByPrimaryKey(id);
        return BaseResponse.success(null);
    }

    @RequestMapping("update")
    @ResponseBody
    BaseResponse update(@RequestBody ProductInfo banner){
        productInfoMapper.updateByPrimaryKeySelective(banner);
        return BaseResponse.success(null);
    }

    @RequestMapping("find")
    @ResponseBody
    BaseResponse find(@RequestParam("id") Integer id){
        ProductInfo config = productInfoMapper.selectByPrimaryKey(id);
        return BaseResponse.success(config);
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",required = false, defaultValue = "20") Integer pageSize){
        int count = productInfoMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<ProductInfo> list = productInfoMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }

    @RequestMapping("relatedList")
    @ResponseBody
    public BasePageResponse relatedList(@RequestParam("subCatagoryId") Integer subCatagoryId){
        int count = productInfoMapper.countBySubCata(subCatagoryId);
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        List<ProductInfo> list = productInfoMapper.listBySubCata(subCatagoryId);

        BasePageResponse response = BasePageResponse.success(list, count, 0);
        return response;
    }

    @RequestMapping("unRelatedList")
    @ResponseBody
    public BasePageResponse unRelatedList(@RequestParam("subCatagoryId") Integer subCatagoryId){
        int count = productInfoMapper.countUnRelatedBySubCata(subCatagoryId);
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        List<ProductInfo> list = productInfoMapper.listUnRelatedBySubCata(subCatagoryId);

        BasePageResponse response = BasePageResponse.success(list, count, 0);
        return response;
    }
}
