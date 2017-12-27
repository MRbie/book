package com.bie.system.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.UserInfo;
import com.bie.system.service.UserInfoInsertService;
import com.bie.system.service.impl.UserInfoInsertServiceImpl;

/**
 * 用户查询的Sevlet
 * @author Administrator
 *
 */
//@WebServlet("/system/user/select")
public class UserInfoSelectServlet extends HttpServlet{

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
		UserInfoInsertService UserInfoInsertService = new UserInfoInsertServiceImpl();
		request.setCharacterEncoding("utf-8");
		//获取查询的条件,账号或者用户姓名
		UserInfo users = new UserInfo();
		//获取到查询的是账号还是姓名
		String condition = request.getParameter("condition");
		//获取到查询的条件
		String content = request.getParameter("content");
		System.out.println("content:" + content);
		String userAccount = null;
		String userName = null;
		if(condition!= null && condition.equals("userName")){
			userName = content;
		}
		if(condition!= null && condition.equals("userAccount")){
			userAccount = content;
		}
		users.setUserAccount(userAccount);
		users.setUserName(userName);
		
		List<UserInfo> selectUser = UserInfoInsertService.selectUser(users);
		//将获取的用户信息保存到域中
		request.setAttribute("list", selectUser);
		//查询条件回显
		String result = null;
		if(userAccount != null){
			result = userAccount;
		}
		if(userName != null){
			result = userName;
		}
		request.setAttribute("result", result);
		//转化操作,携带数据
		request.getRequestDispatcher("/view/system/userinfo/userinfo_list.jsp").forward(request, response);
	}

	
}
