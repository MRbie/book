package com.bie.po;

import java.io.Serializable;

public class UserBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userBookId;//用户图书编号
	private Integer userId;//用户编号
	private Integer bookId;//图书编号
	private String userBookStatus;//借书还是还书
	
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
	public UserBook(Integer userId, Integer bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
	}
	
	
	public String getUserBookStatus() {
		return userBookStatus;
	}
	public void setUserBookStatus(String userBookStatus) {
		this.userBookStatus = userBookStatus;
	}
	
	@Override
	public String toString() {
		return "UserBook [userBookId=" + userBookId + ", userId=" + userId + ", bookId=" + bookId + ", userBookStatus="
				+ userBookStatus + "]";
	}
	public UserBook(Integer userId, Integer bookId, String userBookStatus) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.userBookStatus = userBookStatus;
	}
	
	
	
}
