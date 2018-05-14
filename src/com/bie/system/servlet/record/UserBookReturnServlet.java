package com.bie.system.servlet.record;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.UserBook;
import com.bie.system.service.UserBookService;
import com.bie.system.service.impl.UserBookServiceImpl;

//@WebServlet("/system/userbook/return")
public class UserBookReturnServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserBookService service = new UserBookServiceImpl();
		
		//
		UserBook ub = new UserBook();
		ub.setUserBookStatus("还书");
		List<UserBook> selectUserBookBorrow = service.selectUserBookBorrow(ub);
		if(selectUserBookBorrow != null && !"".equals(selectUserBookBorrow)){
			//将获取的用户信息保存到域中
			request.setAttribute("list", selectUserBookBorrow);
		}
		
		//转化操作,携带数据
		request.getRequestDispatcher("/view/system/record/userbook_borrow.jsp").forward(request, response);
	}
	
	
}
