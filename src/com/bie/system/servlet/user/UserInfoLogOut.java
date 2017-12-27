package com.bie.system.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户退出操作
 * @author Administrator
 *
 */
//@WebServlet("/system/user/logout")
public class UserInfoLogOut extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//清空session里面的数据
		session.invalidate();
		
		request.getRequestDispatcher("/view/system/main/login.jsp").forward(request, response);
		
	}
}
