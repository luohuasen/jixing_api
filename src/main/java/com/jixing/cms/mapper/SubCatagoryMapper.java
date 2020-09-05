package com.jixing.cms.mapper;

import com.jixing.cms.model.SubCatagory;

public interface SubCatagoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubCatagory record);

    int insertSelective(SubCatagory record);

    SubCatagory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubCatagory record);

    int updateByPrimaryKey(SubCatagory record);
}