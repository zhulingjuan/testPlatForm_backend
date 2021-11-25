package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageMenuVo extends PageMenuVoChild {
    String redirect = "noRedirect";
    List<PageMenuVoChild> children;
}
