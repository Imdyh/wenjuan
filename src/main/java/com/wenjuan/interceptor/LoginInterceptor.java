package com.wenjuan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wenjuan.entity.User;

/**
 * 后台拦截器，判断用户是否登录
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月11日 下午2:14:18
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//如果未登录，则重定向到首页
		if(user==null) {
			response.sendRedirect("/wenjuan/");
			return false;
		}
		return true;
	}
	
}
