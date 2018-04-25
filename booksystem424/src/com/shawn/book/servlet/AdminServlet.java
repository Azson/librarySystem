package com.shawn.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shawn.book.factory.ServiceFactory;
import com.shawn.book.util.MD5Code;
import com.shawn.book.util.ValidateUtils;
import com.shawn.book.vo.Admin;

public class AdminServlet extends HttpServlet{
	
	private static final long serialVersionUID = -9132124124978042276L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "/pages/errors.jsp";	//定义错误页面
		
		///pages/back/AdminServlet/login 截取login这个字段
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		
		if(status != null){
			if("login".equals(status)){
				path = this.login(request);
			} else if("logout".equals(status)){
				path = this.logout(request);
			} else if("reg".equals(status)){
				path = this.reg(request);
			}
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	public String reg(HttpServletRequest request) {
		String msg = "";
		String url = "";
		
		String aid = request.getParameter("aid");
		String password = request.getParameter("password");
		if(ValidateUtils.validateEmpty(aid) && 
				ValidateUtils.validateEmpty(password)){
			Admin vo = new Admin();
			vo.setAid(aid);
			vo.setFlag(0);
			vo.setPassword(new MD5Code().getMD5ofStr(vo.getPassword()+vo.getAid()));
			vo.setStatus(1);//默认激活
			try {
				if(ServiceFactory.getIAdminServiceInstance().insert(vo)){
					msg = "添加管理员成功！";
					url = "pages/back/admin/admin_insert.jsp";
				} else {
					msg = "添加管理员失败，请重新添加！";
					url = "pages/back/admin/admin_insert.jsp";
				}
			} catch (Exception e) {
				msg = "添加管理员出现异常，请重新添加！";
				url = "pages/back/admin/admin_insert.jsp";
				e.printStackTrace();
			}
		} else {
			msg = "数据不能为空！";
			url = "pages/back/admin/admin_insert.jsp";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	/**
	 * 实现登录
	 * @param request
	 * @return
	 */
	public String login(HttpServletRequest request){
		String msg = ""; //表示提示信息
		String url = ""; //表示跳转路径
		
		//去的页面中传递过来的数据
		String aid = request.getParameter("aid");
		String password = request.getParameter("password");
		
		//判断数据是否为空
		if(ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){//表示数据存在
			Admin vo = new Admin();
			vo.setAid(aid);	//取得参数
			vo.setPassword(new MD5Code().getMD5ofStr(password+aid)); //需要加盐处理
			try {
				if(ServiceFactory.getIAdminServiceInstance().login(vo)){
					request.getSession().setAttribute("aid", aid);	//保存aid
					request.getSession().setAttribute("lastdate", vo.getLastDate());
					request.getSession().setAttribute("flag", vo.getFlag());
					msg = "登陆成功！";
					url = "pages/back/index.jsp";
				} else {
					msg = "登录失败，错误的ID或密码！";
					url = "login.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			msg = "数据不能为空";
			url = "login.jsp";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("url",url);
		return "/pages/forward.jsp";
	}
	
	public String logout(HttpServletRequest request) {
		String msg = "";
		String url = "";
		
		request.getSession().invalidate();//表示session失效
		msg = "已经成功退出系统，请重新登录！";
		url = "login.jsp";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}
	
}
