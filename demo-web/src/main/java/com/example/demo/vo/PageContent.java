package com.example.demo.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class PageContent {
    JSONObject data;
    String URL;


    public PageContent(JSONObject data, String URL) {
        this.data = data;
        this.URL = URL;
    }
}
