package com.jixing.cms.mapper;

import com.jixing.cms.model.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    int count();

    List<Banner> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}