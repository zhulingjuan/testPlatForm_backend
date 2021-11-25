package com.example.demo.vo;

import lombok.Data;

@Data
public class PageMenuVoChild {
    String path;
    String component;
    String name;
    String proxyPath;
    Meta meta;
}
