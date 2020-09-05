package com.jixing.cms.mapper;

import com.jixing.cms.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int count();

    List<Product> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}