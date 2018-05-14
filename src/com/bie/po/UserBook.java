package com.bie.po;

import java.io.Serializable;
import java.util.Date;

public class UserBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userBookId;//用户图书编号
	private Integer userId;//用户编号
	private Integer bookId;//图书编号
	private String userBookStatus;//借书还是还书
	
	private String userAccount;//借阅人账号
	private String userName;//借阅人姓名
	private String bookName;//借阅图书
	private Date userBookDate;//借阅日期
	
	
	private UserInfo userInfo;//用户信息
	private Book book;//图书信息
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getUserBookId() {
		return userBookId;
	}
	public void setUserBookId(Integer userBookId) {
		this.userBookId = userBookId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getUserBookStatus() {
		return userBookStatus;
	}
	public void setUserBookStatus(String userBookStatus) {
		this.userBookStatus = userBookStatus;
	}
	
	//toString 方法
	@Override
	public String toString() {
		return "UserBook [userBookId=" + userBookId + ", userId=" + userId + ", bookId=" + bookId + ", userBookStatus="
				+ userBookStatus + "]";
	}
	
	//构造方法
	public UserBook(Integer userId, Integer bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
	}
	
	//含参的构造方法
	public UserBook(Integer userId, Integer bookId, String userBookStatus) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.userBookStatus = userBookStatus;
	}
	
	
	//含参的构造方法
	public UserBook(Integer userId, Integer bookId, String userBookStatus, Date userBookDate) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.userBookStatus = userBookStatus;
		this.userBookDate = userBookDate;
	}
	//空构造方法
	public UserBook() {
		super();
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public Date getUserBookDate() {
		return userBookDate;
	}
	public void setUserBookDate(Date userBookDate) {
		this.userBookDate = userBookDate;
	}
	
	
}
