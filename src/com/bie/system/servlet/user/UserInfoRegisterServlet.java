package com.bie.system.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.UserInfo;
import com.bie.system.service.UserInfoInsertService;
import com.bie.system.service.impl.UserInfoInsertServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

public class UserInfoRegisterServlet extends HttpServlet{

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
		//使用工具直接获取到前台传过来的数据
		UserInfo user=RequestBeanUtils.requestToSimpleBean(request, UserInfo.class);
		System.out.println(user);//测试到这里是否出现bug,打印注册信息
		
		//然后在servlet层调用service逻辑处理层
		UserInfoInsertService service=new UserInfoInsertServiceImpl();
				
		boolean flag = service.registerUser(user);
		if(flag){
			//成功就跳转到登录页面
			request.getRequestDispatcher("/view/system/main/login.jsp").forward(request, response);
		}else{
			//失败就跳转到注册页面
			request.getRequestDispatcher("/view/system/main/register.jsp").forward(request, response);
		}
	
	}

	
}
