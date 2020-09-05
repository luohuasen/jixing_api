package com.jixing.cms.mapper;

import com.jixing.cms.model.ProductCatagoryKey;

public interface ProductCatagoryMapper {
    int deleteByPrimaryKey(ProductCatagoryKey key);

    int insert(ProductCatagoryKey record);

    int insertSelective(ProductCatagoryKey record);
}