package com.bie.system.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.Book;
import com.bie.system.service.BookService;
import com.bie.system.service.impl.BookServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/***
 * 1.7：这里使用servlet3.0,说明一下，
 * 同时使用了RequestBeanUtils,这个要求表单的name属性必须和实体类UserInfo的成员变量名称一致
 * 		使用方法如下
 * 注解的要求是模块名称加功能比如/system/userinfoinsert，避免后面发生错误
 * @author biehongli
 *
 */
//@WebServlet("/system/book/insert")
public class BookInsertServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;//序列号

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//RequestBeanUtils的使用方法，需要导入三个包。
		//commons-beanutils-1.8.3.jar  commons-logging-1.1.1.jar
		//commy-web-0.0.1.jar
		Book book=RequestBeanUtils.requestToSimpleBean(request, Book.class);
		System.out.println(book);//测试到这里是否出现bug
		//然后在servlet层调用service逻辑处理层
		BookService service = new BookServiceImpl();
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.insertBook(book);
		//返回提示信息到页面
		if(mark){
			request.setAttribute("info", "图书信息添加成功！！！");
		}else{
			request.setAttribute("info", "图书信息添加失败！！！");
		}
		//转发到页面(重定向)book_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/book/book_info.jsp").forward(request, response);
	}
			
}
