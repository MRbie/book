package com.bie.system.servlet.bookSort;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.BookSort;
import com.bie.system.service.BookSortService;
import com.bie.system.service.impl.BookSortServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

//@WebServlet("system/bookSort/insert")
public class BookSortInsertServlet extends HttpServlet{

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
		//RequestBeanUtils的使用方法，需要导入三个包。
		//commons-beanutils-1.8.3.jar  commons-logging-1.1.1.jar
		//commy-web-0.0.1.jar
		BookSort bookSort=RequestBeanUtils.requestToSimpleBean(request, BookSort.class);
		System.out.println(bookSort);//测试到这里是否出现bug
		//然后在servlet层调用service逻辑处理层
		BookSortService service = new BookSortServiceImpl();
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.insertBookSort(bookSort);
		//返回提示信息到页面
		if(mark){
			request.setAttribute("info", "图书类别信息添加成功！！！");
		}else{
			request.setAttribute("info", "图书类别信息添加失败！！！");
		}
		//转发到页面(重定向)book_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/bookSort/bookSort_info.jsp").forward(request, response);
	}

	
	
}
