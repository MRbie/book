package com.bie.system.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.Book;
import com.bie.po.UserInfo;
import com.bie.system.service.BookService;
import com.bie.system.service.impl.BookServiceImpl;

/**
 * 用户查询的Sevlet
 * @author Administrator
 *
 */
//@WebServlet("/system/book/select")
public class BookSelectServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookServiceImpl();
		request.setCharacterEncoding("utf-8");
		//获取查询的条件,书名或者作者
		Book book = new Book();
		//获取到查询的是账号还是姓名
		String condition = request.getParameter("condition");
		//获取到查询的条件bookName bookAuthor
		String content = request.getParameter("content");
		System.out.println("content:" + content);
		String bookName = null;
		String bookAuthor = null;
		if(condition!= null && condition.equals("bookName")){
			bookName = content;
		}
		if(condition!= null && condition.equals("bookAuthor")){
			bookAuthor = content;
		}
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		
		List<Book> selectBook = service.selectBook(book);
		//将获取的用户信息保存到域中
		request.setAttribute("list", selectBook);
		//查询条件回显
		String result = null;
		if(bookName != null){
			result = bookName;
		}
		if(bookAuthor != null){
			result = bookAuthor;
		}
		request.setAttribute("result", result);
		//转化操作,携带数据
		request.getRequestDispatcher("/view/system/book/book_list.jsp").forward(request, response);
	}

	
}
