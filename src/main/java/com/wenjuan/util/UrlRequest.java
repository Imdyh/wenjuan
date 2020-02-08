package com.wenjuan.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年9月1日 下午8:44:10
 */
public class UrlRequest {
	public static String getUrlInfo(String urlStr) throws IOException {
		URL url=new URL(urlStr);
		URLConnection con = url.openConnection();
		HttpURLConnection connection=(HttpURLConnection)con;
		Integer code = connection.getResponseCode();
		if(code==400) {
			System.err.println("返回状态码是是400，获取数据失败！");
			return null;
		}
		InputStream in = con.getInputStream();
		String req="";
		int len;
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		while ((len=in.read(buffer))!=-1) {
			byteout.write(buffer, 0, len);
		}
		byte[] b=byteout.toByteArray();
		req=new String(b,"utf-8");//获得了服务器返回的信息
		
		return req;
	}
}
