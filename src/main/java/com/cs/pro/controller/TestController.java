
package com.cs.pro.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cs.pro.model.UserBean;
import com.cs.pro.service.UserService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	@ResponseBody
	public Object testGet(String data)
	{
		return testPost(data);
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST)
	@ResponseBody
	public Object testPost(String data)
	{
		System.err.println(data);
		JSONObject obj = JSONObject.parseObject(data);
		int id = Integer.parseInt(obj.getString("id"));
		UserBean user = userService.getUser(id);
		return user;
	}
	
	
	
}
