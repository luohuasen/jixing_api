package com.jixing.cms.mapper;

import com.jixing.cms.model.ProductCatagoryKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatagoryMapper {
    int deleteByPrimaryKey(ProductCatagoryKey key);

    int insert(ProductCatagoryKey record);

    int insertSelective(ProductCatagoryKey record);
}