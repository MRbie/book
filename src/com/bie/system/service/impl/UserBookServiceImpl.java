package com.bie.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bie.po.UserBook;
import com.bie.po.UserInfo;
import com.bie.system.dao.UserBookDao;
import com.bie.system.dao.impl.UserBookDaoImpl;
import com.bie.system.service.UserBookService;
import com.bie.utils.BaseDao;

public class UserBookServiceImpl implements UserBookService{

	private UserBookDao userBookDao = new UserBookDaoImpl();
	
	@Override
	public boolean insertUser(UserBook ub) {
		try{
			if(ub!=null && ub.getBookId()!=null && ub.getUserId() != null){
				//sql语句
				String sql="INSERT INTO user_book(userId,bookId,userBookStatus,userBookDate) VALUES(?,?,?,?)";
				List<Object> list=new ArrayList<Object>();
				//可以理解位将实体类中get到的信息放到数据库中，因为set设置的信息就是为了查到数据库中
				list.add(ub.getUserId());//将设置好的账号信息保存到集合中
				list.add(ub.getBookId());//将设置好的账号信息保存到集合中
				list.add(ub.getUserBookStatus());//将设置好的账号信息保存到集合中
				list.add(ub.getUserBookDate());//将设置好的账号信息保存到集合中
				
				
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
	public List<UserBook> selectUserBookBorrow(UserBook ub, UserInfo user) {
		//select u.*,b.*,ub.* 
		//from user_info u,book_info b,user_book ub 
		//where u.user_id=ub.userId and b.book_id=ub.bookId 
		//and ub.userBookStatus="借书"
		StringBuilder sql=new StringBuilder("select u.user_id,u.user_account,b.book_id,b.book_name,ub.*"
				+ "from user_info u,book_info b,user_book ub "
				+ " where u.user_id=ub.userId and b.book_id=ub.bookId and 1=1 and u.user_account = '" + user.getUserAccount() + "'");
		List<Object> list=new ArrayList<Object>();
		if(ub!=null){
			//按照姓名查询
			if(ub.getUserBookStatus()!=null && !ub.getUserBookStatus().equals("")){
				sql.append(" and userBookStatus = ? ");
				list.add(ub.getUserBookStatus());
			}
			if(ub.getBookName()!=null && !ub.getBookName().equals("")){
				sql.append(" and b.book_name = ? ");
				list.add(ub.getBookName());
			}
		}
		sql.append(" order by userBookId desc ");
		return userBookDao.selectUserBook(sql.toString(), list.toArray());
	}

	
	//暂时未用到
	/*@Override
	public List<UserBook> selectUserBookReturn(UserBook ub) {
		StringBuilder sql=new StringBuilder("select * from user_book where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		if(ub!=null){
			//按照姓名查询
			if(ub.getUserBookStatus()!=null && !ub.getUserBookStatus().equals("")){
				sql.append(" and userBookStatus = ? ");
				list.add(ub.getUserBookStatus());
			}
		}
		sql.append(" order by userBookId desc ");
		return userBookDao.selectUserBook(sql.toString(), list.toArray());
	}*/

	
	
}
