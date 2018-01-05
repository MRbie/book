package com.bie.system.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bie.po.Book;
import com.bie.system.service.BookService;
import com.bie.system.service.impl.BookServiceImpl;
import com.bie.utils.JsonUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//@WebServlet("/system/userinfo/show")
public class UserInfoShowServlet extends HttpServlet{

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
		BookService service = new BookServiceImpl();
		request.setCharacterEncoding("utf-8");
		//获取查询的条件,书名或者作者
		//Book book = new Book();
		List<Book> selectBook = service.selectBook(null);
		//将获取的用户信息保存到域中
		//request.setAttribute("list", selectBook);
		
		JSONObject json = new JSONObject();
		json.put("list", selectBook);
		//JSONArray json = new JSONArray();
		//json.add(selectBook);
		System.out.println("JSON格式的数据:" + json);
		
		response.setContentType("application/json; charset=UTF-8");
        //已经将数据封装为一个JsonObject
        PrintWriter out = response.getWriter();
        //将json对象转换为字符串传递到Jsp界面上去
        String jsonString = JsonUtils.toJSONString(json);
        //如果不是json格式就将其转化为json格式的数据
        System.out.println("JSON格式的数据:" + jsonString);
        out.write(jsonString);
        out.flush();
        out.close();
		//转化操作,携带数据,这里返回json
		//request.getRequestDispatcher("/view/system/book/book_list.jsp").forward(request, response);
	}

	
}
