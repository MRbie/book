package com.bie.system.service;

import java.util.List;

import com.bie.po.UserBook;

public interface UserBookService {
	
	//借书和还书记录插入
	public boolean insertUser(UserBook ub);
	
	//查阅借书和还书记录
	public List<UserBook> selectUserBookBorrow(UserBook ub);
	
	//public List<UserBook> selectUserBookReturn(UserBook ub);
}
