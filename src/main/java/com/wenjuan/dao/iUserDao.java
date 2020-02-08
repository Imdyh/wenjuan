package com.wenjuan.dao;

import com.wenjuan.entity.QQUser;
import com.wenjuan.entity.User;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月11日 下午3:38:34
 */
public interface iUserDao {
	
	/**
	 * 查询tb_qq中是否存在此openid对应的信息
	 * @param openid
	 * @return
	 */
	public QQUser selectQqUserByOpenid(String openid);
	
	/**
	 * 通过qq的主键id查询tb_user中是否存在信息
	 * @param id
	 * @return
	 */
	public User selectUserByQQid(String id);
	
	/**
	 * 向数据库表tb_user中写入user信息
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * 向tb_qq中写入qquser
	 * @param qqUser
	 * @return
	 */
	public Integer insertQQuser(QQUser qqUser);
}
