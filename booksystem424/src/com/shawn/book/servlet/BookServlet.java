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
import com.shawn.book.vo.Admin;
import com.shawn.book.vo.Book;
import com.shawn.book.vo.Item;

public class BookServlet extends HttpServlet{
	
	private static final long serialVersionUID = -9132124124978042276L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/pages/errors.jsp";	//定义错误页面
		///pages/back/book/BookServlet/insertPro 截取insertPro这个字段
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(status != null){
			if("insertPro".equals(status)){
				path = this.insertPro(request);
			} else if("insert".equals(status)){
				path = this.insert(request,response);
			} else if("listSplit".equals(status)){
				path = this.listSplit(request,response);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private String insertPro(HttpServletRequest request) {
		Map<String, Object> map;
		try {
			map = ServiceFactory.getIBookServiceInstance().findByAdminAndItem();
			request.setAttribute("allItems", map.get("allItems"));
			request.setAttribute("allAdmins", map.get("allAdmins"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/pages/back/book/book_insert.jsp";
	}
	
	private String insert(HttpServletRequest request,
			HttpServletResponse response) {
		String msg = "";
		String url = "";
		//取得页面数据
		String name = request.getParameter("name");
		String aid = request.getParameter("aid");
		Integer iid = Integer.parseInt(request.getParameter("iid"));
		String note = request.getParameter("note");
		//判断数据是否为空
		if(ValidateUtils.validateEmpty(name) &&
				ValidateUtils.validateEmpty(aid) &&
				ValidateUtils.validateEmpty(note)){
			Book vo = new Book();
			vo.setName(name);
			Admin admin = new Admin();
			admin.setAid(aid);
			vo.setAdmin(admin);
			Item item = new Item();
			item.setIid(iid);
			vo.setItem(item);
			vo.setCredate(new Date());
			vo.setStatus(1);//0 下架 1 正常，默认值为正常。
			vo.setNote(note);
			try {
				if(ServiceFactory.getIBookServiceInstance().insert(vo)){
					msg = "数据已经增加成功！";
					url = "pages/back/book/BookServlet/insertPro";
				} else {
					msg = "你输入的数据有误，请重新输入！";
					url = "pages/back/book/BookServlet/insertPro";
				}
			} catch (Exception e) {
				msg = "数据添加异常，请重新输入！";
				url = "pages/back/book/BookServlet/insertPro";
				e.printStackTrace();
			}
		} else {
			msg = "输入的内容为空，请重新输入！";
			url = "pages/back/book/BookServlet/insertPro";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/pages/forward.jsp";
	}
	
	public String listSplit(HttpServletRequest request,
			HttpServletResponse response) {
		Integer currentPage = 1;
		Integer lineSize = 5;
		try{
			currentPage = Integer.parseInt(request.getParameter("cp") == null ? "1" : request.getParameter("cp"));
			lineSize = Integer.parseInt(request.getParameter("ls") == null ? "5" : request.getParameter("ls"));
		} catch(Exception e){
			e.printStackTrace();
		}
		String keyWord = request.getParameter("kw");
		String column = request.getParameter("col");
		if(keyWord == null){
			keyWord = "";
		}
		if(column == null){
			column = "name";
		}
		
		try {
			Map<String,Object> map = 
					ServiceFactory.getIBookServiceInstance().listBySplit(column, keyWord, currentPage, lineSize);
			request.setAttribute("allBook", map.get("allBook"));
			request.setAttribute("allRecorders", map.get("allRecord"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("url", "pages/back/book/BookServlet/listSplit");
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lineSize", lineSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("keyWord", keyWord);
		
		return "/pages/back/book/book_list.jsp";
	}
	
}
