package com.wenjuan.entity;
/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月10日 上午11:57:38
 */
public class User {
	private Integer id;
	private String email;
	private String password;
	private String nickname;
	private String headicon;
	private String qq_id;//对应的qq_id
	private Integer role=0;//1管理员，0注册用户
	private String regtime="CURRENT_TIMESTAMP";//注册时间
	private Integer status=0;//1允许登陆，0禁止登陆
	
	private QQUser qqUser;//对应的qq用户对象

	public User() {
		super();
	}

	public User(String email, String password, String nickname, String headicon, String qq_id, Integer role,
			String regtime, Integer status, QQUser qqUser) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.headicon = headicon;
		this.qq_id = qq_id;
		this.role = role;
		this.regtime = regtime;
		this.status = status;
		this.qqUser = qqUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadicon() {
		return headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}

	public String getQq_id() {
		return qq_id;
	}

	public void setQq_id(String qq_id) {
		this.qq_id = qq_id;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public QQUser getQqUser() {
		return qqUser;
	}

	public void setQqUser(QQUser qqUser) {
		this.qqUser = qqUser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", nickname=" + nickname
				+ ", headicon=" + headicon + ", qq_id=" + qq_id + ", role=" + role + ", regtime=" + regtime
				+ ", status=" + status + ", qqUser=" + qqUser + "]";
	}
}
