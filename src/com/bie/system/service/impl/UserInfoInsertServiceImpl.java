package com.bie.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bie.po.UserInfo;
import com.bie.system.dao.UserInfoDao;
import com.bie.system.dao.impl.UserInfoDaoImpl;
import com.bie.system.service.UserInfoInsertService;
import com.bie.utils.BaseDao;
import com.bie.utils.DbUtils;
import com.bie.utils.MarkUtils;
/***
 * 1.4:这是业务逻辑层的实现类，实现用户信息的接口
 * 
 * 切忌新手写好service业务逻辑层需要test测试(junit)
 * @author biehongli
 *
 */
public class UserInfoInsertServiceImpl implements UserInfoInsertService{

	//引入dao层对象,方便调用
	private UserInfoDao userInfoDao = new UserInfoDaoImpl();
	
	@Override
	public boolean insertUser(UserInfo user) {
		try{
			//System.out.println(user);//测试传来的UserInfo里面是否够存在用户信息
			if(user!=null && user.getUserAccount()!=null){
				String sql="INSERT INTO user_info(user_account,user_pw,"
						+ "user_number,user_name,user_age,user_sex,user_mark)"
						+ " VALUES(?,?,?,?,?,?,?)";
				List<Object> list=new ArrayList<Object>();
				//可以理解位将实体类中get到的信息放到数据库中，因为set设置的信息就是为了查到数据库中
				list.add(user.getUserAccount());//将设置好的账号信息保存到集合中
				list.add(user.getUserPw());//将设置好的账号信息保存到集合中
				list.add(user.getUserNumber());//将设置好的密码信息保存到集合中
				list.add(user.getUserName());//将设置好的姓名信息保存到集合中
				list.add(user.getUserAge());//将设置好的年龄信息保存到集合中
				list.add(user.getUserSex());//将设置好的性别信息保存到集合中
				list.add(user.getUserMark());//将设置好的标识信息保存到集合中
				
				//后台只可以添加管理员
				//user.setUserMark(MarkUtils.USER_MARK_MANAGER);
				//将设置为默认的管理员添加到数据库
				//list.add(user.getUserMark());
				
				//将封装到集合list中的信息和sql语句传递到DbUtils封装好的 方法中
				//这里sql转化位String语句，list转化位数组类型
				int count=BaseDao.addAndUpdate(sql.toString(), list.toArray());
				//System.out.println(count);//测试返回值是0还是1
				if(count>0){
					return true;//成功返回true
				}else{
					return false;//失败返回false
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserInfo login(UserInfo user) {
		UserInfo login = new UserInfo();
		if(user != null && user.getUserAccount() != null && user.getUserPw()!=null && !"".equals(user.getUserAccount()) && !"".equals(user.getUserPw())){
			login = userInfoDao.login(user);
		}
		return login;
	}

	
	@Override
	public List<UserInfo> selectUser(UserInfo user) {
		//sql语句
		//String sql="select * from user ";
		StringBuilder sql=new StringBuilder("select * from user_info where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(user!=null){
			//按照姓名查询
			if(user.getUserName()!=null && !user.getUserName().equals("")){
				sql.append(" and user_name like ? ");
				list.add(user.getUserName());
			}
			//按照用户账号查询
			if(user.getUserAccount()!=null && !user.getUserAccount().equals("")){
				sql.append(" and user_account like ? ");
				list.add(user.getUserAccount());
			}
			
		}
		return userInfoDao.selectUser(sql.toString(), list.toArray());
	}

	@Override
	public boolean deleteUser(UserInfo user) {
		try {
			//不做伪删除，这里做真删除
			String sql = "DELETE FROM user_info WHERE user_id=? ";
			List<Object> list = new ArrayList<Object>();
			list.add(user.getUserId());
			
			boolean mark = BaseDao.addUpdateDelete(sql, list.toArray());
			if(mark){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public boolean updateUser(UserInfo user) {
		try {
			String sql = "update user_info set user_account=?,user_pw=?,user_number=?,user_name=?,user_age=?,user_sex=?,user_mark=?  where user_id=? ";
			List<Object> list = new ArrayList<Object>();
			
			if(user != null){
				list.add(user.getUserAccount());//将设置好的账号信息保存到集合中
				list.add(user.getUserPw());//将设置好的账号信息保存到集合中
				list.add(user.getUserNumber());//将设置好的密码信息保存到集合中
				list.add(user.getUserName());//将设置好的姓名信息保存到集合中
				list.add(user.getUserAge());//将设置好的年龄信息保存到集合中
				list.add(user.getUserSex());//将设置好的性别信息保存到集合中
				list.add(user.getUserMark());//将设置好的标识信息保存到集合中
				
				list.add(user.getUserId());
			}
			boolean mark = BaseDao.addUpdateDelete(sql, list.toArray());
			if(mark){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public UserInfo getUserId(UserInfo user) {
		try {
			if(user != null){
				return userInfoDao.getUserId(user.getUserId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean registerUser(UserInfo user) {
		try{
			//System.out.println(user);//测试传来的UserInfo里面是否够存在用户信息
			if(user!=null && user.getUserAccount()!=null){
				String sql="INSERT INTO user_info(user_account,user_pw,"
						+ "user_number,user_name,user_age,user_sex,user_mark)"
						+ " VALUES(?,?,?,?,?,?,?)";
				List<Object> list=new ArrayList<Object>();
				//可以理解位将实体类中get到的信息放到数据库中，因为set设置的信息就是为了查到数据库中
				list.add(user.getUserAccount());//将设置好的账号信息保存到集合中
				list.add(user.getUserPw());//将设置好的账号信息保存到集合中
				list.add(user.getUserNumber());//将设置好的密码信息保存到集合中
				list.add(user.getUserName());//将设置好的姓名信息保存到集合中
				list.add(user.getUserAge());//将设置好的年龄信息保存到集合中
				list.add(user.getUserSex());//将设置好的性别信息保存到集合中
				//list.add(user.getUserMark());//将设置好的标识信息保存到集合中
				
				//注册只可以注册普通学生
				user.setUserMark(MarkUtils.USER_MARK_MEMBER);
				//将设置为默认的管理员添加到数据库
				list.add(user.getUserMark());
				
				//将封装到集合list中的信息和sql语句传递到DbUtils封装好的 方法中
				//这里sql转化位String语句，list转化位数组类型
				int count=BaseDao.addAndUpdate(sql.toString(), list.toArray());
				//System.out.println(count);//测试返回值是0还是1
				if(count>0){
					return true;//成功返回true
				}else{
					return false;//失败返回false
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
