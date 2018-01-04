package com.bie.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bie.po.Book;
import com.bie.po.BookSort;
import com.bie.system.dao.BookSortDao;
import com.bie.utils.BaseDao;

/***
 * 图书类别的dao层
 * @author Administrator
 *
 */
public class BookSortDaoImpl implements BookSortDao{

	@Override
	public List<BookSort> selectBookSort(String sql, Object[] arr) {
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
			List<BookSort> list = new ArrayList<BookSort>();
			while(rs.next()){
				BookSort bookSort = new BookSort();
				bookSort.setBookSortId(rs.getInt("book_sort_id"));
				bookSort.setBookSortName(rs.getString("book_sort_name"));
				bookSort.setBookSortExtend(rs.getString("book_sort_extend"));
				bookSort.setBookSortMark(rs.getString("book_sort_mark"));
				
				//测试数据
				list.add(bookSort);
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
	public BookSort getBookSortId(Integer bookSortId) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from book_sort where book_sort_id=? ";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, bookSortId);
            rs=ps.executeQuery();//5:执行sql语句
            BookSort bookSort = null;
            if(rs.next()){
            	bookSort=new BookSort();
                //从数据库中获取值设置到实体类的setter方法中
            	bookSort.setBookSortId(rs.getInt("book_sort_id"));
				bookSort.setBookSortName(rs.getString("book_sort_name"));
				bookSort.setBookSortExtend(rs.getString("book_sort_extend"));
				bookSort.setBookSortMark(rs.getString("book_sort_mark"));
				
                return bookSort;
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
