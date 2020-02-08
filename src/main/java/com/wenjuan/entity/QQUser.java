package com.wenjuan.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月15日 上午11:14:22
 */
@Getter
@Setter
@ToString
public class QQUser extends BaseEntity{
	private String openid;
	private String nickname;
	private String gender;
	private String province;
	private String city;
	private String year;
	private String constellation;
	private String figureurl_1;//50*50qq空间头像
	private String figureurl_qq_1;//qq头像40*40
	public QQUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QQUser(String openid, String nickname, String gender, String province, String city, String year,
			String constellation, String figureurl_1, String figureurl_qq_1) {
		super();
		this.openid = openid;
		this.nickname = nickname;
		this.gender = gender;
		this.province = province;
		this.city = city;
		this.year = year;
		this.constellation = constellation;
		this.figureurl_1 = figureurl_1;
		this.figureurl_qq_1 = figureurl_qq_1;
	}
	@Override
	public String toString() {
		return "QQUser [id=" + id + ", openid=" + openid + ", nickname=" + nickname + ", gender=" + gender
				+ ", province=" + province + ", city=" + city + ", year=" + year + ", constellation=" + constellation
				+ ", figureurl_1=" + figureurl_1 + ", figureurl_qq_1=" + figureurl_qq_1 + "]";
	}
	
	
}
