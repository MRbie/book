package com.bie.system.service;

import java.util.List;

import com.bie.po.Book;
import com.bie.po.UserInfo;

/**
 * 图书的业务逻辑层
 * @author Administrator
 *
 */

public interface BookService {

	/***
	 * 向数据库插入(添加)数据(图书的信息)
	 * @param user  图书的信息
	 * @return true表示插入成功，false表示插入失败
	 */
	public boolean insertBook(Book book);
	
	
	/***
	 * 图书查询的信息
	 * @param Book
	 * @return
	 */
	public List<Book> selectBook(Book book);
	
	/***
	 * 删除，可做假删除，也可以做真删除
	 * @param Book
	 * @return
	 */
	public boolean deleteBook(Book book);
	
	/***
	 * 图书修改的方法
	 * @param Book
	 * @return
	 */
	public boolean updateBook(Book book);

	/**
	 * 根据图书id进行查询操作
	 * @param Book
	 * @return
	 */
	public Book getBookId(Book book);
	
	
	/***
	 * 借书操作
	 * @param Book
	 * @return
	 */
	public boolean borrowBook(Book book);
	
	/***
	 * 还书操作
	 * @param Book
	 * @return
	 */
	public boolean repayBook(Book book);
}
