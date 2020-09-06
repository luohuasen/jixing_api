package com.jixing.cms.mapper;

import com.jixing.cms.model.SubCatagory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCatagoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubCatagory record);

    int insertSelective(SubCatagory record);

    SubCatagory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubCatagory record);

    int updateByPrimaryKey(SubCatagory record);

    /**
     * 根据一级分类查询二级分类
     * @param id
     * @return
     */
    List<SubCatagory> list(Integer id);


    List<SubCatagory> listAll();
}