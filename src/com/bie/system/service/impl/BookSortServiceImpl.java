package com.bie.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bie.po.BookSort;
import com.bie.system.dao.BookSortDao;
import com.bie.system.dao.impl.BookSortDaoImpl;
import com.bie.system.service.BookSortService;
import com.bie.utils.BaseDao;

public class BookSortServiceImpl implements BookSortService{

	private BookSortDao bookSortDao = new BookSortDaoImpl();
	
	@Override
	public boolean insertBookSort(BookSort bookSort) {
		try{
			//book_sort_name book_sort_extend book_sort_mark book_sort
			if(bookSort!=null){
				String sql="INSERT INTO book_sort(book_sort_name,book_sort_extend,book_sort_mark)"
						+ " VALUES(?,?,?)";
				List<Object> list=new ArrayList<Object>();
				//可以理解位将实体类中get到的信息放到数据库中，因为set设置的信息就是为了查到数据库中
				list.add(bookSort.getBookSortName());
				list.add(bookSort.getBookSortExtend());
				list.add(bookSort.getBookSortMark());
				
				
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
	public List<BookSort> selectBookSort(BookSort bookSort) {
		//book_sort_name book_sort_extend book_sort_mark book_sort
		StringBuilder sql=new StringBuilder("select * from book_sort where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(bookSort!=null){
			//按照图书类别名称查询
			if(bookSort.getBookSortName()!=null && !bookSort.getBookSortName().equals("")){
				//添加模糊查询功能
				sql.append(" and book_sort_name like ? ");
				list.add(bookSort.getBookSortName());
			}
			
			
		}
		return bookSortDao.selectBookSort(sql.toString(), list.toArray());
	}

	@Override
	public boolean deleteBookSort(BookSort bookSort) {
		try {
			//book_sort_id book_sort_name book_sort_extend book_sort_mark book_sort
			//不做伪删除，这里做真删除
			String sql = "DELETE FROM book_sort WHERE book_sort_id=? ";
			List<Object> list = new ArrayList<Object>();
			list.add(bookSort.getBookSortId());
			
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
	public boolean updateBookSort(BookSort bookSort) {
		try {
			//book_sort_id book_sort_name book_sort_extend book_sort_mark book_sort
			String sql = "update book_sort set book_sort_name=?,book_sort_extend=?,book_sort_mark=? where book_sort_id=? ";
			List<Object> list = new ArrayList<Object>();
			
			if(bookSort != null){
				list.add(bookSort.getBookSortName());
				list.add(bookSort.getBookSortExtend());
				list.add(bookSort.getBookSortMark());
				
				list.add(bookSort.getBookSortId());
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
	public BookSort getBookSortId(BookSort bookSort) {
		try {
			if(bookSort != null){
				return bookSortDao.getBookSortId(bookSort.getBookSortId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
