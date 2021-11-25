package com.example.demo.mybatis.mapper;


import com.example.demo.mybatis.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PageMapper {
    int insert(Page record);

    int insertSelective(Page record);

    int update(Page record);


    List<Page> getFirstMenu();

    List<Page> getChildrenMenu();

    List<Page> queryContentByParentPathAndChildPath(@Param("firstPath")String firstPath, @Param("secondPath")String secondPath);
}