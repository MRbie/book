package com.bie.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bie.po.UserInfo;

/**
 * 过滤非法请求的过滤器
 * @author Administrator
 *
 */
//@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		//获取HttpServletRequest
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		//获取session
		HttpSession session=request.getSession();
		//获取session域中的值
		UserInfo user=(UserInfo)session.getAttribute("userLogin");
		//获取地址
		String uri=request.getRequestURI();
		
		if(uri.contains("/system/user/login")){//后台登陆成功允许跳转
			filterChain.doFilter(servletRequest, servletResponse);
		}else if(uri.contains("view/system/main/register.jsp")){//允许跳转到注册页面
			filterChain.doFilter(servletRequest, servletResponse);
		}else if(uri.contains("/system/user/register")){//允许注册操作
			filterChain.doFilter(servletRequest, servletResponse);
		}else if(uri.contains("/system/")){//允许用户和图书操作
			filterChain.doFilter(servletRequest, servletResponse);
		}else if(uri.contains("/resource/")){//允许引用样式
			filterChain.doFilter(servletRequest, servletResponse);
		}else if(user !=null ){
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
			//RequestDispatcher rd=request.getRequestDispatcher("");
			//rd.forward(servletRequest, servletResponse);
			request.getRequestDispatcher("/view/system/main/login.jsp").forward(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
