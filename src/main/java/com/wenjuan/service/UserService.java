package com.wenjuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenjuan.dao.iUserDao;
import com.wenjuan.entity.QQUser;
import com.wenjuan.entity.User;

/**
 * @author 董玉杭   qq:1943295589
 * @email Struggle.dyh@qq.com
 * @datetime 2019年10月11日 下午3:55:38
 */
@Service
public class UserService {
	
	@Autowired
	private iUserDao userDao;
	
	/**
	 * 通过openid查询表tb_qq中是否存在该用户
	 * @param openid
	 * @return
	 */
	public QQUser findQqUserByOpenid(String openid) {
		return userDao.selectQqUserByOpenid(openid);
	}
	
	/**
	 * 通过qqUser的id查询tb_user表中是否存在对应的id
	 * @param id
	 * @return
	 */
	public User findUserByQQid(String id) {
		return userDao.selectUserByQQid(id);
	}
	
	/**
	 * 向数据库表tb_user中插入user信息
	 * @param user
	 * @return
	 */
	public Integer addUser(User user) {
		return userDao.insertUser(user);
	}
	
	/**
	 * 将qquser添加到tb_qq
	 * @param qqUser
	 * @return
	 */
	public Integer addQQuser(QQUser qqUser) {
		return userDao.insertQQuser(qqUser);
	}
	
	
//	
//	/**
//	 * qq用户登录时判断该用户是否已经存在数据库中
//	 * @param openid
//	 * @return
//	 */
//	public User findUserbyOpenid(String openid) {
//		return userDao.selectUserByOpenid(openid);
//	}
//	
//	/**
//	 * 通过qq登录的用户，在数据库中查找对应的信息
//	 * @param qq_id
//	 * @return
//	 */
//	public User findUserByqq_id(String qq_id) {
//		return userDao.selectUserByqq_id(qq_id);
//	}
//	
//	/**
//	 * 添加qq用户
//	 * @param user
//	 * @return
//	 */
//	public Integer addQQuser(QQUser qqUser) {
//		return userDao.insertuserByqq(qqUser);
//	}
//	
//	
}
