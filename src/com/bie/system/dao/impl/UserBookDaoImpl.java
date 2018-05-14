package com.bie.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bie.po.UserBook;
import com.bie.po.UserInfo;
import com.bie.system.dao.UserBookDao;
import com.bie.utils.BaseDao;

public class UserBookDaoImpl implements UserBookDao{

	@Override
	public List<UserBook> selectUserBook(String sql, Object[] arr) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=BaseDao.getCon();//第一步连接数据库
			ps=con.prepareStatement(sql);//第二步：预编译
			if(arr!=null){
				for(int i=0;i<arr.length;i++){
					ps.setObject(i+1, arr[i]);
				}
			}
			//第四步执行sql
			rs=ps.executeQuery();
			List<UserBook> list=new ArrayList<UserBook>();
			while(rs.next()){
				UserBook ub=new UserBook();
				ub.setUserBookId(rs.getInt("userBookId"));
				ub.setUserId(rs.getInt("userId"));
				ub.setBookId(rs.getInt("bookId"));
				ub.setUserBookStatus(rs.getString("userBookStatus"));
				ub.setUserAccount(rs.getString("user_account"));
				ub.setBookName(rs.getString("book_name"));
				ub.setUserBookDate(rs.getDate("userBookDate"));
				
				list.add(ub);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭资源，避免出现异常
			BaseDao.close(con, ps, rs);
		}
		
		return null;
	}

	
}
