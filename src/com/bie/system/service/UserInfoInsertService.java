package com.bie.system.service;

import java.util.List;

import com.bie.po.UserInfo;

/***
 * 1.3：如果没有在工具类DbUtils中封装addAndUpdate，
 *    那么需要现在dao层(数据访问层)写和数据库相关操作的代码
 *    如果封装好了，直接在service(业务逻辑层)写代码即可。
 * 我的习惯实现写接口再写实现接口的类。
 * @author biehongli
 *
 */
public interface UserInfoInsertService {

	/***
	 * 向数据库插入(添加)数据(用户的信息)
	 * @param user  用户的信息
	 * @return true表示插入成功，false表示插入失败
	 */
	public boolean insertUser(UserInfo user);
	
	/***
	 * 用户登录的方法
	 * @param user
	 * @return
	 */
	public UserInfo login(UserInfo user);
	
	
	/***
	 * 用户查询的信息
	 * @param user
	 * @return
	 */
	public List<UserInfo> selectUser(UserInfo user);
	
	/***
	 * 删除，可做假删除，也可以做真删除
	 * @param userId
	 * @return
	 */
	public boolean deleteUser(UserInfo user);
	
	/***
	 * 用户修改的方法
	 * @param user
	 * @return
	 */
	public boolean updateUser(UserInfo user);

	/**
	 * 根据用户id进行查询操作
	 * @param user
	 * @return
	 */
	public UserInfo getUserId(UserInfo user);
	
	
	/***
	 * 注册用户
	 * 向数据库插入(添加)数据(用户的信息)
	 * @param user  用户的信息
	 * @return true表示插入成功，false表示插入失败
	 */
	public boolean registerUser(UserInfo user);
}
