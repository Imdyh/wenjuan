package com.wenjuan.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wenjuan.config.QqConfig;
import com.wenjuan.entity.QQUser;
import com.wenjuan.entity.User;
import com.wenjuan.util.UrlRequest;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月11日 下午3:31:59
 */
@Controller
public class LoginService {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 通过code获取access-token
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public String getaccesstoken(String code) throws IOException {
		String url= "https://graph.qq.com/oauth2.0/token";
		String grant_type="authorization_code";
		String urlstr=url+"?code="+code+
				"&grant_type="+grant_type+
				"&client_secret="+QqConfig.CLIENT_SECRET+
				"&redirect_uri="+QqConfig.REDIRECT_URI+
				"&client_id="+QqConfig.CLIENT_ID;
		String res = UrlRequest.getUrlInfo(urlstr);
		return res;
	}
	
	/**
	 * 通过acces-token获取openid
	 * @param access_token
	 * @return
	 * @throws IOException
	 */
	public String getopenid(String access_token) throws IOException {
		String url1="https://graph.qq.com/oauth2.0/me?access_token="+access_token;
		String callback = UrlRequest.getUrlInfo(url1);
		callback=callback.substring(callback.indexOf("(")+1, callback.lastIndexOf(")"));
		JSONObject jsonObject1=(JSONObject)JSON.parse(callback);
		String openid=jsonObject1.getString("openid");
		return openid;
	}
	
	/**
	 * 通过openid获取用户user
	 * @param openid
	 * @param access_token
	 * @return
	 * @throws IOException
	 */
	public User getqqUserInfo(String openid,String access_token) throws IOException {
		User user=null;
		String url="https://graph.qq.com/user/get_user_info";
		url+="?access_token="+access_token+"&oauth_consumer_key="+QqConfig.CLIENT_ID+"&openid="+openid;
		String userinfo = UrlRequest.getUrlInfo(url);
		JSONObject userinfoJsonObject=JSONObject.parseObject(userinfo);
		String ret=userinfoJsonObject.getString("ret");
		if(ret.equals("0")) {
			//成功
			String nickname=userinfoJsonObject.getString("nickname");
			String gender=userinfoJsonObject.getString("gender");
			String province=userinfoJsonObject.getString("province");
			String city=userinfoJsonObject.getString("city");
			String year=userinfoJsonObject.getString("year");
			String constellation=userinfoJsonObject.getString("constellation");
			String figureurl_1=userinfoJsonObject.getString("figureurl_1");//50*50qq空间头像
			String figureurl_qq_1=userinfoJsonObject.getString("figureurl_qq_1");//qq头像40*40
			QQUser qqUser=new QQUser(openid,nickname, gender, province, city, year, constellation, figureurl_1, figureurl_qq_1);
			//查询此qq用户在数据库表tb_qq中是否存在
			//1、查询表tb_qq中是否存在qqUser信息
			QQUser tempQqUser = userService.findQqUserByOpenid(openid);
			if(tempQqUser!=null) {
				//查询tb_user表中是否存在此qq的id
				User tempUser = userService.findUserByQQid(tempQqUser.getId());
				//如果存在返回此tempUser对象
				if(tempUser!=null) {
					tempUser.setQqUser(tempQqUser);
					return tempUser;
				}else {
					//如果不存在则向tb_user写入数据
					tempUser = new User();
					tempUser.setQq_id(tempQqUser.getId());
					tempUser.setRole(0);
					tempUser.setStatus(1);
					Integer flag = userService.addUser(tempUser);
					if(flag>0) {
						System.out.println("新增用户到tb_user成功");
						tempUser.setQqUser(tempQqUser);
						return tempUser;
					}else {
						System.out.println("新增用户到tb_user失败");
					}	
				}
			}else {
				//将qquser写入tb_qq
				Integer flag = userService.addQQuser(qqUser);		
				if(flag>0) {
					//添加成功，向tb_user中写入数据
					User tempUser=new User();
					tempUser.setQq_id(qqUser.getId());
					tempUser.setRole(0);
					tempUser.setStatus(1);
					Integer flag1 = userService.addUser(tempUser);
					if(flag1>0) {
						System.out.println("添加tempUser到数据库成功");
						tempUser.setQqUser(qqUser);
						return tempUser;
					}else {
						System.out.println("添加tempUser到数据库失败");
					}
				}else {
					//添加失败
					System.out.println("添加qquser到数据库失败");
				}
			}
		}
		return user;
	}
}
