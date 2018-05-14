package com.bie.po;

import java.io.Serializable;

/***
 * 1.2:写用户信息的实体类
 * 需要和自己设计好的数据库信息相对应。
 * @author biehongli
 *
 */
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//userId userAccount userPw userNumber userName userAge userSex userMark
	private Integer userId;//用户编号
	private String userAccount;//用户账号
	private String userPw;//用户密码
	private String userNumber;//用户学号
	private String userName;//用户姓名
	private Integer userAge;//用户年龄
	private String  userSex;//用户性别
	private String userMark;//用户标识，可以使用一张表，完成管理员和用户
	//如果对setxxx,getxxx灰常熟练了，自动生成即可
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}
	//重写toString()方法
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userAccount=" + userAccount + ", userPw=" + userPw + ", userNumber="
				+ userNumber + ", userName=" + userName + ", userAge=" + userAge + ", userSex=" + userSex
				+ ", userMark=" + userMark + "]";
	}
	
	
}
