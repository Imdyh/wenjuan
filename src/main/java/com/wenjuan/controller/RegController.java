package com.wenjuan.controller;

import com.wenjuan.entity.User;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wenjuan.util.ResultMap;

/**
 * 用户注册页面
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月11日 下午2:04:32
 */
@Controller
@RequestMapping("api")
@Api(tags = "RegController",description = "用户注册")
public class RegController {
	
	/**
	 * 请求注册页面地址
	 * @return
	 */
	@GetMapping("reg")
	public String reg() {
		return "reg";
	}
	
	/**
	 * 用户通过邮箱注册请求地址
	 * @param user
	 * @return
	 */
	@GetMapping("toreg")
	public ResultMap toreg(User user) {
		return null;
	}
}
