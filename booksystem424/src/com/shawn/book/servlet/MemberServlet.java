package com.shawn.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shawn.book.factory.ServiceFactory;
import com.shawn.book.util.ValidateUtils;
import com.shawn.book.vo.Member;

public class MemberServlet extends HttpServlet{
	
	private static final long serialVersionUID = -9132124124978042276L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/pages/errors.jsp";	//定义错误页面
		///pages/back/member/MemberServlet/insert 截取insert这个字段
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(status != null){
			if("insert".equals(status)){
				path = this.insert(request);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public String insert(HttpServletRequest request){
		String msg = "";
		String url = "";
		//接收数据
		String mid = request.getParameter("mid");
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Integer sex = Integer.parseInt(request.getParameter("sex"));
		String phone = request.getParameter("phone");
		//验证数据是否为空
		if(ValidateUtils.validateEmpty(mid) && 
				ValidateUtils.validateEmpty(name) &&
				ValidateUtils.validateEmpty(phone)){
			Member vo = new Member();
			vo.setMid(mid);
			vo.setName(name);
			vo.setAge(age);
			vo.setSex(sex);
			vo.setPhone(phone);
			try {
				if(ServiceFactory.getIMmeberServiceInstance().insert(vo)){
					url = "pages/back/member/member_insert.jsp";
					msg = "用户数据增加成功！";
				} else {
					url = "pages/back/member/member_insert.jsp";
					msg = "用户数据增加失败！";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
			url = "pages/back/member/member_insert.jsp";
			msg = "数据不能为空！";
		}
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		return "/pages/forward.jsp";
	}
}
