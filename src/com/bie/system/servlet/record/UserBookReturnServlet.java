package com.bie.system.servlet.record;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bie.po.UserBook;
import com.bie.po.UserInfo;
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
		
		String bookName = request.getParameter("bookName");
		
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("userLogin");
		//String userAccount = user.getUserAccount();
		
		
		//
		UserBook ub = new UserBook();
		//
		ub.setBookName(bookName);
		ub.setUserBookStatus("还书");
		List<UserBook> selectUserBookBorrow = service.selectUserBookBorrow(ub, user);
		if(selectUserBookBorrow != null && !"".equals(selectUserBookBorrow)){
			request.setAttribute("result", bookName);
			//将获取的用户信息保存到域中
			request.setAttribute("list", selectUserBookBorrow);
		}
		
		//转化操作,携带数据
		request.getRequestDispatcher("/view/system/record/userbook_borrow.jsp").forward(request, response);
	}
	
	
}
