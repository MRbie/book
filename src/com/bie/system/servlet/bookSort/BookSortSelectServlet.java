package com.bie.system.servlet.bookSort;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.BookSort;
import com.bie.system.service.BookSortService;
import com.bie.system.service.impl.BookSortServiceImpl;

//@WebServlet("system/bookSort/select")
public class BookSortSelectServlet extends HttpServlet{

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
		request.setCharacterEncoding("utf-8");
		BookSort bookSort = new BookSort();
		
		//获取到查询的是账号还是姓名
		String condition = request.getParameter("condition");
		//获取到查询的条件bookSortName
		String content = request.getParameter("content");
		System.out.println("content:" + content);
		String bookSortName = null;
		if(condition!= null && condition.equals("bookSortName")){
			bookSortName = content;
		}
		bookSort.setBookSortName(bookSortName);
		
		//直接调用图书类别的业务逻辑层
		BookSortService service = new BookSortServiceImpl();
		List<BookSort> selectBookSort = service.selectBookSort(bookSort);
		//将获取的用户信息保存到域中
		request.setAttribute("list", selectBookSort);
		//查询条件回显
		String result = null;
		if(bookSortName != null){
			result = bookSortName;
		}
		request.setAttribute("result", result);
		//转化操作,携带数据
		request.getRequestDispatcher("/view/system/bookSort/bookSort_list.jsp").forward(request, response);
	}

	
	
}
