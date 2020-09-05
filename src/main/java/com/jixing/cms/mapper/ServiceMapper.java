package com.jixing.cms.mapper;

import com.jixing.cms.model.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    int count();

    List<Service> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}