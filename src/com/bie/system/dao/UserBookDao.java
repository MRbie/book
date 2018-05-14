package com.bie.system.dao;

import java.util.List;

import com.bie.po.UserBook;

public interface UserBookDao {

	public List<UserBook> selectUserBook(String sql,Object[] arr);
}
