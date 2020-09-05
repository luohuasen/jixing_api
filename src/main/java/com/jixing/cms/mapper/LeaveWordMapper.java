package com.jixing.cms.mapper;

import com.jixing.cms.model.LeaveWord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveWord record);

    int insertSelective(LeaveWord record);

    LeaveWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveWord record);

    int updateByPrimaryKey(LeaveWord record);

    int count();

    List<LeaveWord> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}