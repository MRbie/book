package com.bie.system.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.UserInfo;
import com.bie.system.service.UserInfoInsertService;
import com.bie.system.service.impl.UserInfoInsertServiceImpl;

/**
 * 用户修改的方法
 * @author Administrator
 *
 */
//@WebServlet("/system/userinfo/delete")
public class UserInfoDeleteServlet extends HttpServlet{

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
		UserInfo user = new UserInfo();
		//获取到用户id
		String userId = request.getParameter("userId");
		user.setUserId(Integer.parseInt(userId));
		
		//然后在servlet层调用service逻辑处理层
		UserInfoInsertService service=new UserInfoInsertServiceImpl();
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.deleteUser(user);
		//返回提示信息到页面
		if(mark){
			request.setAttribute("info", "用户信息删除成功！！！");
		}else{
			request.setAttribute("info", "用户信息删除失败！！！");
		}
		//转发到页面(重定向)user_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/userinfo/user_info.jsp").forward(request, response);
	}
	
	
}
