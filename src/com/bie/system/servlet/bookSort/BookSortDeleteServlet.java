package com.bie.system.servlet.bookSort;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.BookSort;
import com.bie.system.service.BookSortService;
import com.bie.system.service.impl.BookSortServiceImpl;

//@WebServlet("system/bookSort/delete")
public class BookSortDeleteServlet extends HttpServlet{

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
		BookSort bookSort = new BookSort();
		//获取到用户id
		String bookSortId = request.getParameter("bookSortId");
		bookSort.setBookSortId(Integer.parseInt(bookSortId));
		
		//然后在servlet层调用service逻辑处理层
		BookSortService service = new BookSortServiceImpl();
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.deleteBookSort(bookSort);
		//返回提示信息到页面
		if(mark){
			request.setAttribute("info", "图书类别信息删除成功！！！");
		}else{
			request.setAttribute("info", "图书类别信息删除失败！！！");
		}
		//转发到页面(重定向)user_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/bookSort/bookSort_info.jsp").forward(request, response);
	
	}

	
	
}
