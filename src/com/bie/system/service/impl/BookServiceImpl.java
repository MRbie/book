package com.bie.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bie.po.Book;
import com.bie.system.dao.BookDao;
import com.bie.system.dao.impl.BookDaoImpl;
import com.bie.system.service.BookService;
import com.bie.utils.BaseDao;

public class BookServiceImpl implements BookService{

	private BookDao bookDao = new BookDaoImpl();
	@Override
	public boolean insertBook(Book book) {
		try{
			//book_id book_name book_author book_price book_type book_publish book_sum book_mark
			if(book!=null){
				String sql="INSERT INTO book_info(book_name,book_author,book_price,book_type,book_publish,book_sum)"
						+ " VALUES(?,?,?,?,?,?)";
				List<Object> list=new ArrayList<Object>();
				//可以理解位将实体类中get到的信息放到数据库中，因为set设置的信息就是为了查到数据库中
				list.add(book.getBookName());
				list.add(book.getBookAuthor());
				list.add(book.getBookPrice());
				list.add(book.getBookType());
				list.add(book.getBookPublish());
				list.add(book.getBookSum());
				
				//将封装到集合list中的信息和sql语句传递到DbUtils封装好的 方法中
				//这里sql转化位String语句，list转化位数组类型
				int count=BaseDao.addAndUpdate(sql.toString(), list.toArray());
				//System.out.println(count);//测试返回值是0还是1
				if(count>0){
					return true;//成功返回true
				}else{
					return false;//失败返回false
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> selectBook(Book book) {
		StringBuilder sql=new StringBuilder("select * from book_info where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(book!=null){
			//按照图书名称查询
			if(book.getBookName()!=null && !book.getBookName().equals("")){
				sql.append(" and book_name = ? ");
				list.add(book.getBookName());
			}
			//按照用户账号查询
			if(book.getBookAuthor()!=null && !book.getBookAuthor().equals("")){
				sql.append(" and book_author = ? ");
				list.add(book.getBookAuthor());
			}
			
		}
		return bookDao.selectBook(sql.toString(), list.toArray());
	}

	@Override
	public boolean deleteBook(Book book) {
		try {
			//不做伪删除，这里做真删除
			String sql = "DELETE FROM book_info WHERE book_id=? ";
			List<Object> list = new ArrayList<Object>();
			list.add(book.getBookId());
			
			boolean mark = BaseDao.addUpdateDelete(sql, list.toArray());
			if(mark){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		try {
			String sql = "update book_info set book_name=?,book_author=?,book_price=?,book_type=?,book_publish=?,book_sum=? where book_id=? ";
			List<Object> list = new ArrayList<Object>();
			
			if(book != null){
				list.add(book.getBookName());
				list.add(book.getBookAuthor());
				list.add(book.getBookPrice());
				list.add(book.getBookType());
				list.add(book.getBookPublish());
				list.add(book.getBookSum());
				
				list.add(book.getBookId());
			}
			boolean mark = BaseDao.addUpdateDelete(sql, list.toArray());
			if(mark){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Book getBookId(Book book) {
		try {
			if(book != null){
				return bookDao.getBookId(book.getBookId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean borrowBook(Book book) {
		try {
			String sql = "update book_info set book_sum=? where book_id=? ";
			List<Object> list = new ArrayList<Object>();
			if(book != null){
				if(book.getBookSum() <= 0){
					book.setBookSum(0);
					list.add(book.getBookSum());
				}else{
					list.add(book.getBookSum()-1);
				}
				list.add(book.getBookId());
			}
			boolean mark = BaseDao.addUpdateDelete(sql, list.toArray());
			if(mark){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean repayBook(Book book) {
		try {
			String sql = "update book_info set book_sum=? where book_id=? ";
			List<Object> list = new ArrayList<Object>();
			if(book != null){
				list.add(book.getBookSum() + 1);
				list.add(book.getBookId());
			}
			boolean mark = BaseDao.addUpdateDelete(sql, list.toArray());
			if(mark){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	
}
