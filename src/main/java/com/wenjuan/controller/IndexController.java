package com.wenjuan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月10日 上午11:36:49
 */
@Controller
@Api(tags = "IndexController",description = "首页地址")
public class IndexController {
	
	/**
	 * 请求首页地址
	 * @return
	 */
	@GetMapping( path = {"index","/"})
	@ApiOperation(value = "首页",notes = "返回首页地址")
	public String index() {
		return "index";
	}
}
