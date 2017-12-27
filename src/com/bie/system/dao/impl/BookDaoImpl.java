package com.bie.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bie.po.Book;
import com.bie.po.UserInfo;
import com.bie.system.dao.BookDao;
import com.bie.utils.BaseDao;

public class BookDaoImpl implements BookDao{

	@Override
	public List<Book> selectBook(String sql, Object[] arr) {
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
			List<Book> list = new ArrayList<Book>();
			while(rs.next()){
				//book_id book_name book_author book_price book_type book_publish book_sum book_mark
				Book books = new Book();
                books.setBookId(rs.getInt("book_id"));
                books.setBookName(rs.getString("book_name"));
				books.setBookAuthor(rs.getString("book_author"));
                books.setBookPrice(rs.getDouble("book_price"));
				books.setBookType(rs.getString("book_type"));
                books.setBookPublish(rs.getString("book_publish"));
				books.setBookSum(rs.getInt("book_sum"));
                books.setBookMark(rs.getString("book_mark"));
				
				//测试数据
				//System.out.println(user);
				list.add(books);
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

	@Override
	public Book getBookId(Integer bookId) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from book_info where book_id=? ";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, bookId);
            rs=ps.executeQuery();//5:执行sql语句
            Book books = null;
            if(rs.next()){
            	books=new Book();
                //从数据库中获取值设置到实体类的setter方法中
            	 books.setBookId(rs.getInt("book_id"));
                 books.setBookName(rs.getString("book_name"));
 				 books.setBookAuthor(rs.getString("book_author"));
                 books.setBookPrice(rs.getDouble("book_price"));
 				 books.setBookType(rs.getString("book_type"));
                 books.setBookPublish(rs.getString("book_publish"));
 				 books.setBookSum(rs.getInt("book_sum"));
                 books.setBookMark(rs.getString("book_mark"));
                return books;
            }else{
                return null;
            }
            
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
