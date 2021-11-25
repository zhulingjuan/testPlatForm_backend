package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.DynFrameService;
import com.example.demo.GetUserInfoService;
import com.example.demo.adaptor.PageAdaptor;
import com.example.demo.mybatis.entity.Page;
import com.example.demo.queryBean.MenuContent;
import com.example.demo.vo.JsonResult;
import com.example.demo.vo.PageContent;
import com.example.demo.vo.PageMenuVo;
import com.example.demo.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author paida 派哒 zeyu.pzy@alibaba-inc.com
 */
@Controller
@RequestMapping("/mock")
public class MockController {


	@ResponseBody
	@PostMapping("/mockForm")
	public JsonResult mockForm(@RequestBody JSONObject jsonObject) {
		System.out.println(JSON.toJSON(jsonObject));
		return JsonResult.createBySuccess();
	}

}
