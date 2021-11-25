package com.example.demo;

import com.example.demo.mybatis.entity.Page;

import java.util.List;
import java.util.Map;

public interface DynFrameService {
    void save(Page page);

    Map<String,List<Page>> queryList();

    Page queryContent(String firstPath,String secondPath);
}
