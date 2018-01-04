package com.bie.system.dao;

import java.util.List;

import com.bie.po.UserInfo;

/**
 * 用户信息的操作的dao层接口
 * @author Administrator
 *
 */
public interface UserInfoDao {

	/***
	 * 用户登录的方法
	 * @param user
	 * @return
	 */
	public UserInfo login(UserInfo user);
	
	/***
	 * 查询用户的信息
	 * @param sql
	 * @param arr
	 * @return
	 */
	public List<UserInfo> selectUser(String sql,Object[] arr);

	/**
	 * 根据用户id进行查询操作
	 * @param userId
	 * @return
	 */
	public UserInfo getUserId(Integer userId);
	
	
}
