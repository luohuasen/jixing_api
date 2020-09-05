package com.jixing.cms.mapper;

import com.jixing.cms.model.IndustryInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndustryInfo record);

    int insertSelective(IndustryInfo record);

    IndustryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryInfo record);

    int updateByPrimaryKey(IndustryInfo record);

    int count();

    List<IndustryInfo> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}