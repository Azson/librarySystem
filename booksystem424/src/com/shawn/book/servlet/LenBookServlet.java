package com.shawn.book.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shawn.book.factory.ServiceFactory;
import com.shawn.book.util.ValidateUtils;
import com.shawn.book.vo.Book;
import com.shawn.book.vo.LenBook;
import com.shawn.book.vo.Member;

public class LenBookServlet extends HttpServlet{
	
	private static final long serialVersionUID = -9132124124978042276L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/pages/errors.jsp";	//定义错误页面
		///pages/back/lenbook/LenBookServlet/insert 截取insert这个字段
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(status != null){
			if("insert".equals(status)){
				path = this.insert(request);
			} else if("insertPro".equals(status)){
				path = this.insertPro(request);
			} else if("listSplit".equals(status)){
				path = this.listSplit(request);
			} else if("updateByRetdate".equals(status)){
				path = this.updateByRetdate(request);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public String updateByRetdate(HttpServletRequest request) {
		String msg = "";
		String url = "";
		
		//接受参数
		Integer leid = Integer.parseInt(request.getParameter("leid"));
		try {
			if(ServiceFactory.getILenBookServiceInstance().updateByRetdate(leid)){
				msg = "图书已经归还！";
			} else {
				msg = "数据错误，归还失败！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		url = "pages/back/lenbook/LenBookServlet/listSplit";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}
	
	public String insertPro(HttpServletRequest request) {
		try {
			Map<String,Object> map = ServiceFactory.getILenBookServiceInstance().listByMemberAndBooks();
			request.setAttribute("allMembers", map.get("allMembers"));
			request.setAttribute("allBooks", map.get("allBooks"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "/pages/back/lenbook/lenbook_insert.jsp";
	}
	
	public String insert(HttpServletRequest request) {
		String msg = "";
		String url = "";
		
		//接受参数
		int bid = Integer.parseInt(request.getParameter("bid"));
		String mid = request.getParameter("mid");
		if(ValidateUtils.validateEmpty(mid)){
			LenBook vo = new LenBook();
			Book book = new Book();
			book.setBid(bid);
			vo.setBook(book);//设置图书编号
			Member member = new Member();
			member.setMid(mid);
			vo.setMember(member);//设置用户信息
			vo.setCredate(new Date());
			try {
				if(ServiceFactory.getILenBookServiceInstance().insert(vo)){
					msg="数据添加成功！";
				} else {
					msg="数据添加失败，请重新增加！";
				}
			} catch (Exception e) {
				msg="数据添加出现异常，请重新增加！";
				e.printStackTrace();
			}
		}else {
			msg="输入的内容不允许为空！";
		}
		
		url = "pages/back/lenbook/LenBookServlet/insertPro";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}
	
	public String listSplit(HttpServletRequest request) {
		Integer currentPage = 1;
		Integer lineSize = 5;
		try{
			currentPage = Integer.parseInt(request.getParameter("cp"));
			lineSize = Integer.parseInt(request.getParameter("ls"));
		} catch(Exception e){
			e.printStackTrace();
		} 
		String keyWord = request.getParameter("kw");
		String column = request.getParameter("col");
		if(keyWord == null){
			keyWord = "";
		}
		if(column == null){
			column = "mid";
		}
		
		try {
			Map<String,Object> map = 
					ServiceFactory.getILenBookServiceInstance().listBySplit(column, keyWord, currentPage, lineSize);
			request.setAttribute("allLenBooks", map.get("allLenBooks"));
			request.setAttribute("allRecorders", map.get("allRecord"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("url", "pages/back/lenbook/LenBookServlet/listSplit");
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lineSize", lineSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("keyWord", keyWord);
		
		return "/pages/back/lenbook/lenbook_list.jsp";
	}
	
}
