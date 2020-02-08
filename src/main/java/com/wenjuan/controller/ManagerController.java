package com.wenjuan.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月11日 下午2:24:32
 */
@Controller
@RequestMapping("/manager")
@Api(tags = "ManagerController",description = "控制台页面")
public class ManagerController {
	
	@GetMapping("console")
	public String manager() {
		return "manager/console";
	}
}
