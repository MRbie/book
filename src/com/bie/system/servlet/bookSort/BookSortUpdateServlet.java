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

//@WebServlet("system/bookSort/update")
public class BookSortUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用RequestBeanUtils完成数据的获取和封装，但是要求实体类属性和前台的name属性一致哦
		BookSort bookSort = RequestBeanUtils.requestToSimpleBean(request, BookSort.class);
		//然后在servlet层调用service逻辑处理层
		BookSortService service = new BookSortServiceImpl();
		//先查询再修改
		BookSort books = service.getBookSortId(bookSort);
		
		request.setAttribute("bookSort", books);
		request.getRequestDispatcher("/view/system/bookSort/bookSort_update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用工具直接获取到前台传过来的数据
		BookSort bookSort=RequestBeanUtils.requestToSimpleBean(request, BookSort.class);
		System.out.println(bookSort);//测试到这里是否出现bug
		
		//然后在servlet层调用service逻辑处理层
		BookSortService service = new BookSortServiceImpl();

        //查询过后进行修改,对user2进行修改哦，切记不要修改user哦
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.updateBookSort(bookSort);
		/*HttpSession session = request.getSession();
		session.setAttribute("user", user);*/
		//返回提示信息到页面
		if(mark){
			request.setAttribute("info", "图书类别信息修改成功！！！");
		}else{
			request.setAttribute("info", "图书类别信息修改失败！！！");
		}
		//转发到页面(重定向)user_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/bookSort/bookSort_info.jsp").forward(request, response);
	}

	
	
}
