package com.example.demo.adaptor;

import com.alibaba.fastjson.JSON;
import com.example.demo.mybatis.entity.Page;
import com.example.demo.vo.Meta;
import com.example.demo.vo.PageMenuVo;
import com.example.demo.vo.PageMenuVoChild;
import com.example.demo.vo.PageVo;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageAdaptor {
    public static List<PageVo> toPageVo(Map<String,List<Page>> pages){
        ArrayList<PageVo> pageVos = Lists.newArrayList();
        /**
         *  res.put("firstPage",firstPage);
         *         res.put("childrenPage",childrenPage);
         */
        List<Page> firstPage = pages.get("firstPage");
        List<Page> childrenPage = pages.get("childrenPage");
        for(Page page : firstPage){
            PageVo pageVo = new PageVo();
            ArrayList<PageVo> childPageVos = Lists.newArrayList();
            pageVo.setChildren(childPageVos);
            for(Page pageChild : childrenPage){
                if (pageChild.getParentId().equals(page.getId())){
                    PageVo pageVoChildren = new PageVo();
                    pageVoChildren.setIcon(pageChild.getIcon());
                    pageVoChildren.setTitle(pageChild.getTitle());
                    pageVoChildren.setName(pageChild.getName());
                    pageVoChildren.setPath(pageChild.getPath());
                    pageVoChildren.setComponent(pageChild.getVuePath());
                    pageVoChildren.setContent(pageChild.getContent());
                    pageVoChildren.setProxyPath(pageChild.getURL());
                    pageVoChildren.setId(String.valueOf(pageChild.getId()));
                    pageVoChildren.setParentId(String.valueOf(pageChild.getParentId()));
                    childPageVos.add(pageVoChildren);
                }
            }
            pageVo.setPath(page.getPath());
            pageVo.setName(page.getName());
            pageVo.setComponent(page.getVuePath());
            Meta meta = new Meta();
            meta.setIcon(page.getIcon());
            meta.setTitle(page.getTitle());
            pageVo.setIcon(page.getIcon());
            pageVo.setTitle(page.getTitle());
            /**
             * 只有一级目录返回id
             */
            pageVo.setId(String.valueOf(page.getId()));
            pageVo.setContent(page.getContent());
            pageVos.add(pageVo);
        }
        return pageVos;
    }

    public static Page toPage(PageVo pageVo) {
        Page page = new Page();
        page.setIsFirst(pageVo.getParentId() != null ? 0 : 1);
        page.setPath(pageVo.getPath());
        page.setTitle(pageVo.getTitle());
        page.setURL(pageVo.getProxyPath());
        page.setIcon(pageVo.getIcon());
        page.setVuePath(pageVo.getComponent());
        page.setParentId(pageVo.getParentId() != null ? Long.valueOf(pageVo.getParentId()) : null);
        page.setContent(pageVo.getContent());
        page.setId(pageVo.getId() != null ? Long.valueOf(pageVo.getId()): null);
        page.setName(pageVo.getName());
        return page;
    }

    public static List<PageMenuVo> toPageMenuVo(Map<String, List<Page>> queryList) {
        ArrayList<PageMenuVo> pageMenuVos = Lists.newArrayList();
        /**
         *  res.put("firstPage",firstPage);
         *         res.put("childrenPage",childrenPage);
         */
        List<Page> firstPage = queryList.get("firstPage");
        List<Page> childrenPage = queryList.get("childrenPage");
        for(Page page : firstPage){
            PageMenuVo pageMenuVo = new PageMenuVo();
            ArrayList<PageMenuVoChild> childPageVos = Lists.newArrayList();
            pageMenuVo.setChildren(childPageVos);
            for(Page pageChild : childrenPage){
                if (pageChild.getParentId().equals(page.getId())){
                    PageMenuVoChild pageVoChildren = new PageMenuVoChild();
                    Meta meta = new Meta();
                    meta.setIcon(pageChild.getIcon());
                    meta.setTitle(pageChild.getTitle());
                    pageVoChildren.setMeta(meta);
                    pageVoChildren.setName(pageChild.getName());
                    pageVoChildren.setProxyPath(pageChild.getURL());
                    pageVoChildren.setPath(pageChild.getPath());
                    pageVoChildren.setComponent(pageChild.getVuePath());
                    childPageVos.add(pageVoChildren);
                }
            }
            pageMenuVo.setPath(page.getPath());
            pageMenuVo.setName(page.getName());
            pageMenuVo.setComponent(page.getVuePath());
            Meta meta = new Meta();
            meta.setIcon(page.getIcon());
            meta.setTitle(page.getTitle());
            pageMenuVo.setMeta(meta);
            /**
             * 只有一级目录返回id
             */
            pageMenuVos.add(pageMenuVo);
        }
        return pageMenuVos;
    }
}
