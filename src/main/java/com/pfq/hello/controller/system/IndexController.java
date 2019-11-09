package com.pfq.hello.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.pfq.hello.entity.common.LoginParam;
import com.pfq.hello.entity.common.Menu;
import com.pfq.hello.entity.common.Result;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/login.html")
	public ModelAndView loginGet() {
		logger.debug("");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping("/login")
	@ResponseBody
	public Result<Object> loginPost(LoginParam loginParam) {
		logger.debug("login param:{}", JSON.toJSONString(loginParam));
		return new Result<Object>(0, "登入成功");
	}

	@RequestMapping("logout")
	@ResponseBody
	public Result<Object> logout() {
		return new Result<Object>(0, "退出成功");
	}

	@RequestMapping("/index.html")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/home.html")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/console");
		return mv;
	}

	@RequestMapping("/leftMenu")
	@ResponseBody
	public Result<Object> menu() {
		Result<Object> result = new Result<Object>();
		result.setCode(0);
		result.setMsg("");
		List<Menu> list = new ArrayList<Menu>();
		Menu menu2 = new Menu();
		menu2.setTitle("系统管理");
		menu2.setIcon("layui-icon-set-fill");
		List<Menu> list2 = menu2.getList();
		Menu menu3 = new Menu();
		menu3.setTitle("用户管理");
		menu3.setUrl("user/list.action");
		list2.add(menu3);
		Menu menu4 = new Menu();
		menu4.setTitle("默认展开2");
		menu4.setUrl("//www.baidu.com");
		list2.add(menu4);
		menu2.setList(list2);
		list.add(menu2);
		result.setData(list);
		return result;
	}
}
