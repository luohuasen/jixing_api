package com.jixing.cms.mapper;

import com.jixing.cms.model.Catagory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatagoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Catagory record);

    int insertSelective(Catagory record);

    Catagory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catagory record);

    int updateByPrimaryKey(Catagory record);

    List<Catagory> list();
}