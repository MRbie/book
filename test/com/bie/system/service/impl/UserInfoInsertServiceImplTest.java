package com.bie.system.service.impl;

import org.junit.Test;

import com.bie.po.UserInfo;
import com.bie.system.service.UserInfoInsertService;

/***
 * 1.5:测试的类
 * @author biehongli
 *
 */
public class UserInfoInsertServiceImplTest {

	private UserInfoInsertService service=new UserInfoInsertServiceImpl();
	
	//测试的时候出点错，String sql="INSERT INTO user_info(user_account,user_pw,user_number,user_name,user_age,user_sex,user_mark) VALUES(?,?,?,?,?,?,?)";
	//插入语句写字段的时候加了''导致出错，找了一会，所以写好service业务逻辑层测试还是很重要的
	@Test
	public void insert(){
		UserInfo user=new UserInfo();
		user.setUserAccount("别先生");
		user.setUserPw("666666");
		user.setUserNumber("123456789");
		user.setUserName("小别同志");
		user.setUserAge(23);
		user.setUserSex("爷们");
		user.setUserMark("1");
		boolean mark=service.insertUser(user);
		if(mark){
			System.out.println("插入成功！！！");
		}else{
			System.out.println("明天考试了，今天还不复习，失败了吧！！！");
		}
	}
}
