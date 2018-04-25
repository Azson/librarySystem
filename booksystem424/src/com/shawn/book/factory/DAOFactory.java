package com.shawn.book.factory;

import java.sql.Connection;

import com.shawn.book.dao.IAdminDAO;
import com.shawn.book.dao.IBookDAO;
import com.shawn.book.dao.IItemDAO;
import com.shawn.book.dao.ILenBookDAO;
import com.shawn.book.dao.IMemberDAO;
import com.shawn.book.dao.impl.AdminDAOImpl;
import com.shawn.book.dao.impl.BookDAOImpl;
import com.shawn.book.dao.impl.ItemDAOImpl;
import com.shawn.book.dao.impl.LenBookDAOImpl;
import com.shawn.book.dao.impl.MemberDAOImpl;

public class DAOFactory {
	
	public static IAdminDAO getIAdminDAOInstance(Connection conn){ return new AdminDAOImpl(conn); }
	
	public static IMemberDAO getIMemberDAOInstance(Connection conn){ return new MemberDAOImpl(conn); }
	
	public static IItemDAO getIItemDAOInstance(Connection conn){ return new ItemDAOImpl(conn); }
	
	public static IBookDAO getIBookDAOInstance(Connection conn){ return new BookDAOImpl(conn); }
	
	public static ILenBookDAO getILenBookDAOInstance(Connection conn){ return new LenBookDAOImpl(conn); }
	
}
