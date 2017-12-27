package com.bie.system.dao;

import java.util.List;

import com.bie.po.Book;

/***
 * 图书的dao层接口
 * @author Administrator
 *
 */
public interface BookDao {

	/***
	 * 查询图书的信息
	 * @param sql
	 * @param arr
	 * @return
	 */
	public List<Book> selectBook(String sql,Object[] arr);

	/**
	 * 根据用户id进行查询操作
	 * @param userId
	 * @return
	 */
	public Book getBookId(Integer bookId);
}
