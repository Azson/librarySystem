package com.shawn.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class templet extends HttpServlet{
	
	private static final long serialVersionUID = -9132124124978042276L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/pages/errors.jsp";	//定义错误页面
		///pages/back/AdminServlet/login 截取login这个字段
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(status != null){
			if("login".equals(status)){
//				path = this.login(request);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
