package com.jixing.cms.mapper;

import com.jixing.cms.model.ProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    int count();

    List<ProductInfo> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    int countBySubCata(@Param("cataId") Integer cataId);

    List<ProductInfo> listBySubCata(@Param("cataId") Integer cataId);
}