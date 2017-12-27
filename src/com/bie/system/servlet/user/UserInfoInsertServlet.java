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
import com.my.web.servlet.RequestBeanUtils;

/***
 * 1.7：这里使用servlet3.0,说明一下，
 * 同时使用了RequestBeanUtils,这个要求表单的name属性必须和实体类UserInfo的成员变量名称一致
 * 		使用方法如下
 * 注解的要求是模块名称加功能比如/system/userinfoinsert，避免后面发生错误
 * @author biehongli
 *
 */
//@WebServlet("/system/userinfoinsert")
public class UserInfoInsertServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;//序列号

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//RequestBeanUtils的使用方法，需要导入三个包。
		//commons-beanutils-1.8.3.jar  commons-logging-1.1.1.jar
		//commy-web-0.0.1.jar
		UserInfo user=RequestBeanUtils.requestToSimpleBean(request, UserInfo.class);
		System.out.println(user);//测试到这里是否出现bug
		//然后在servlet层调用service逻辑处理层
		UserInfoInsertService service=new UserInfoInsertServiceImpl();
		//调用service逻辑处理层的插入方法,返回布尔类型
		boolean mark=service.insertUser(user);
		//返回提示信息到页面
		if(mark){
			request.setAttribute("info", "用户信息添加成功！！！");
		}else{
			request.setAttribute("info", "用户信息添加失败！！！");
		}
		//转发到页面(重定向)user_info.jsp提示信息，成功或者失败
		request.getRequestDispatcher("/view/system/userinfo/user_info.jsp").forward(request, response);
	}
			
}
