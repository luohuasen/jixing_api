package com.jixing.cms.mapper;

import com.jixing.cms.model.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    int count();

    List<Work> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}