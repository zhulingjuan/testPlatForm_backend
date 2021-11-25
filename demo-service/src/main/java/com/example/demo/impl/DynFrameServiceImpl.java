package com.example.demo.impl;

import com.example.demo.DynFrameService;
import com.example.demo.mybatis.entity.Page;
import com.example.demo.mybatis.mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DynFrameServiceImpl implements DynFrameService {

    @Autowired
    protected PageMapper pageMapper;

    @Override
    public void save(Page page) {
        int i = page.getId() != null ? pageMapper.update(page) : pageMapper.insertSelective(page);
    }

    @Override
    public Map<String,List<Page>> queryList() {
        List<Page> firstPage = pageMapper.getFirstMenu();
        System.out.println();
        List<Page> childrenPage = pageMapper.getChildrenMenu();
        HashMap<String,List<Page>> res = Maps.newHashMap();
        res.put("firstPage",firstPage);
        res.put("childrenPage",childrenPage);
        return res;
    }

    @Override
    public Page queryContent(String firstPath,String secondPath) {
        List<Page> pages = pageMapper.queryContentByParentPathAndChildPath(firstPath, secondPath);
        return pages.get(0);
    }
}
