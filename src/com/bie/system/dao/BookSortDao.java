package com.bie.system.dao;

import java.util.List;

import com.bie.po.Book;
import com.bie.po.BookSort;

public interface BookSortDao {

	/***
	 * 查询图书类别的信息
	 * @param sql
	 * @param arr
	 * @return
	 */
	public List<BookSort> selectBookSort(String sql,Object[] arr);

	/**
	 * 根据图书类别id进行查询操作
	 * @param userId
	 * @return
	 */
	public BookSort getBookSortId(Integer bookSortId);
}
