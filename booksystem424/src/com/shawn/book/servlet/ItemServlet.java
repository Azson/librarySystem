package com.shawn.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shawn.book.factory.ServiceFactory;
import com.shawn.book.util.ValidateUtils;
import com.shawn.book.vo.Item;

public class ItemServlet extends HttpServlet{
	
	private static final long serialVersionUID = -9132124124978042276L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/pages/errors.jsp";	//定义错误页面
		///pages/back/item/ItemServlet/insert 截取insert这个字段
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(status != null){
			if("insert".equals(status)){
				path = this.insert(request);
			} else if("list".equals(status)){
				try {
					List<Item> all = ServiceFactory.getIItemServiceInstance().list();
					request.setAttribute("all", all);
				} catch (Exception e) {
					e.printStackTrace();
				}
				path = this.list(request);
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
		
		String name = request.getParameter("name");
		String note = request.getParameter("note");
		
		//数据验证
		if(ValidateUtils.validateEmpty(name)){
			Item vo = new Item();
			vo.setName(name);
			vo.setNote(note);
			try {
				if(ServiceFactory.getIItemServiceInstance().insert(vo)){
					msg = "数据增加成功！";
					url = "pages/back/item/item_insert.jsp";
				} else {
					msg = "数据增加失败，请重新增加！";
					url = "pages/back/item/item_insert.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			msg = "数据不能为空！";
			url = "pages/back/item/item_insert.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}
	
	public String list(HttpServletRequest request){
		return "/pages/back/item/item_list.jsp";
	}
	
}
