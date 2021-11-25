package com.example.demo.vo;

import lombok.Data;

import java.util.List;


@Data
public class PageVo {
    String path;
    String component;
    String redirect = "noRedirect";
    String name;
    String content;
    String parentId;
    String proxyPath;
    private String title = "";
    private String icon = "";
    String id;
    List<PageVo> children;
}
