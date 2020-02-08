package com.wenjuan.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wenjuan.config.QqConfig;
import com.wenjuan.entity.User;
import com.wenjuan.service.LoginService;
import com.wenjuan.util.ResultMap;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月10日 上午11:18:31
 */
@Controller
@RequestMapping("api")
@Api(tags = "LoginController",description = "登录认证")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	/**
	 * 通过邮箱登录地址
	 * @param user
	 * @return
	 */
	@GetMapping("login")
	@ResponseBody
	@ApiOperation(value = "用户登录",notes = "")
	@ApiResponse(response=User.class, code = 200, message = "接口返回对象参数")
	public ResultMap login(User user) {
		user.setEmail("1943295589@qq.com");
		return new ResultMap(200,"成功",0,user);
	}
	
	/**
	 * 前端请求登录，后端跳转qq登录
	 * @throws IOException 
	 */
	@GetMapping("login/qq")
	public void qqlogin(HttpServletResponse response) throws IOException {
		String url = "https://graph.qq.com/oauth2.0/authorize";
		String state="login";
		String response_type="code";
		url+="?state="+state+
			"&response_type="+response_type+
			"&client_id="+QqConfig.CLIENT_ID+
			"&redirect_uri="+URLEncoder.encode(QqConfig.REDIRECT_URI,"utf-8");
		response.sendRedirect(url);
	}
	
	/**
	 * qq登录的回调地址
	 * @param code
	 * @param state
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@GetMapping("open_api/qq")
	public String openapi_qq(HttpSession session,String code,String state,Model model) throws IOException {
		//1.通过code获取access——token
		String res = loginService.getaccesstoken(code);
		//判断返回的数据,防止多次拿一个code来请求
		if(res.startsWith("callback")) {
			res=res.substring(res.indexOf("(")+1, res.lastIndexOf(")"));
			JSONObject jsonObject1=(JSONObject)JSON.parse(res);
			String error=jsonObject1.getString("error");
			model.addAttribute("error", error+"获取token失败");
			return "error";
		}
		res="{\""+res+"\"}";
		res=res.replaceAll("=", "\":\"");
		res=res.replaceAll("&", "\",\"");
		JSONObject jsonObject=(JSONObject)JSON.parse(res);
		String access_token=jsonObject.getString("access_token");
		//2.通过access_token获取openid
		String openid = loginService.getopenid(access_token);
		//3.通过openid获取用户信息
		User user = loginService.getqqUserInfo(openid, access_token);
		if(user==null) {
			model.addAttribute("error", "获取用户信息失败");
			return "error";
		}
		//4.获取用户信息成功将user写入session
		session.setAttribute("logintype", "qq");
		session.setAttribute("user", user);
		return "redirect:/manager/console";
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@GetMapping("logout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
