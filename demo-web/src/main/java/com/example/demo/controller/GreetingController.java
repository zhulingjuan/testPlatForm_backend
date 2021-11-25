package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.DynFrameService;
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

import com.example.demo.GetUserInfoService;

import java.util.ArrayList;
import java.util.List;


/**
 * @author paida 派哒 zeyu.pzy@alibaba-inc.com
 */
@Controller
@RequestMapping("/dyn")
public class GreetingController {

	@Autowired
	private GetUserInfoService getUserInfoService;

	@Autowired
	private DynFrameService dynFrameService;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="1") String name, Model model) {
		getUserInfoService.getUserInfoById(name, model);
		return "greeting";
	}

	@ResponseBody
	@PostMapping("/saveDyn")
	public JsonResult getdynFrame(@RequestBody PageVo pageVo) {
		System.out.println(JSON.toJSON(pageVo) + "***************");
		dynFrameService.save(PageAdaptor.toPage(pageVo));
		return JsonResult.createBySuccess();
	}

	@ResponseBody
	@PostMapping("/getDynFrame")
	public JsonResult<List<PageVo>> getDynFrame() {
		return JsonResult.createBySuccess(PageAdaptor.toPageVo(dynFrameService.queryList()));
	}

	@ResponseBody
	@PostMapping("/getDynMenu")
	public JsonResult<List<PageMenuVo>> getMenuList() {
		return JsonResult.createBySuccess(PageAdaptor.toPageMenuVo(dynFrameService.queryList()));
	}

	@ResponseBody
	@PostMapping("/getDynMenuContent")
	public JsonResult<PageContent> getDynMenuContent(@RequestBody MenuContent menuContent) {
		Page page = dynFrameService.queryContent(menuContent.getFirstPath(), menuContent.getSecondPath());
		return JsonResult.createBySuccess(new PageContent(JSON.parseObject(page.getContent()),page.getURL()));
	}


}
