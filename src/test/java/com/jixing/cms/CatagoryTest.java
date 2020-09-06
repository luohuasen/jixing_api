package com.jixing.cms;

import com.jixing.cms.mapper.ProductCatagoryMapper;
import com.jixing.cms.mapper.SubCatagoryMapper;
import com.jixing.cms.model.ProductCatagoryKey;
import com.jixing.cms.model.SubCatagory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CatagoryTest extends BaseTest {
    @Autowired
    private SubCatagoryMapper subCatagoryMapper;
    @Autowired
    private ProductCatagoryMapper productCatagoryMapper;

    @Test
    public void addTest(){
        List<SubCatagory> subCatagories = subCatagoryMapper.listAll();
        ProductCatagoryKey productCatagory = new ProductCatagoryKey();
        for(SubCatagory subCatagory : subCatagories){
            for (int i = 1; i < 11; i++) {
                productCatagory.setSubCatagoryId(subCatagory.getId());
                productCatagory.setProductId(i);
                productCatagoryMapper.insertSelective(productCatagory);
            }
        }
    }
}
