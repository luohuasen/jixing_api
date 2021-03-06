package com.jixing.cms.mapper;

import com.jixing.cms.model.Config;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    int count();

    List<Config> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}