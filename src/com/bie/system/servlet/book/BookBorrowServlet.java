package com.bie.system.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bie.po.Book;
import com.bie.po.UserBook;
import com.bie.po.UserInfo;
import com.bie.system.service.BookService;
import com.bie.system.service.UserBookService;
import com.bie.system.service.impl.BookServiceImpl;
import com.bie.system.service.impl.UserBookServiceImpl;
import com.bie.utils.MarkUtils;
import com.my.web.servlet.RequestBeanUtils;

//@WebServlet("/system/book/borrow")
public class BookBorrowServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用RequestBeanUtils完成数据的获取和封装，但是要求实体类属性和前台的name属性一致哦
		Book bookGet = RequestBeanUtils.requestToSimpleBean(request, Book.class);
		//用户借阅图书方法调用
		UserBookService ubs = new UserBookServiceImpl();
		
		//查询登陆用户信息
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("userLogin");
		Integer userId = user.getUserId();
		String userName = user.getUserName();
		String userAccount = user.getUserAccount();
		
		
		
		Book book = new Book();
		//获取到图书id
		String bookId = request.getParameter("bookId");
		book.setBookId(Integer.parseInt(bookId));
		
		//然后在servlet层调用service逻辑处理层
		BookService service = new BookServiceImpl();
		//先查询再修改
		Book books = service.getBookId(bookGet);
		book.setBookSum(books.getBookSum());		
				
		
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.borrowBook(book);
		
		//对借书进行记录
		UserBook ub = new UserBook(userId, Integer.parseInt(bookId), MarkUtils.USER_BOOK_MARK_BORROW);
		boolean insertUser = false;
		if(ub != null && !"".equals(ubs) && !"null".equals(ubs)){
			insertUser = ubs.insertUser(ub);
		}
		//返回提示信息到页面
		if(mark && insertUser){
			request.setAttribute("info", "借书成功！！！");
		}else{
			request.setAttribute("info", "借书失败！！！");
		}
		//转发到页面(重定向)user_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/book/book_info.jsp").forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	
}
