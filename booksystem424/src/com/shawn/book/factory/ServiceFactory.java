package com.shawn.book.factory;

import com.shawn.book.service.IAdminService;
import com.shawn.book.service.IBookService;
import com.shawn.book.service.IItemService;
import com.shawn.book.service.ILenBookService;
import com.shawn.book.service.IMemberService;
import com.shawn.book.service.impl.AdminServiceImpl;
import com.shawn.book.service.impl.BookServiceImpl;
import com.shawn.book.service.impl.ItemServiceImpl;
import com.shawn.book.service.impl.LenBookServiceImpl;
import com.shawn.book.service.impl.MemberServiceImpl;

public class ServiceFactory {
	
	public static IAdminService getIAdminServiceInstance(){ return new AdminServiceImpl(); }
	
	public static IMemberService getIMmeberServiceInstance(){ return new MemberServiceImpl(); }
	
	public static IItemService getIItemServiceInstance(){ return new ItemServiceImpl(); }
	
	public static IBookService getIBookServiceInstance(){ return new BookServiceImpl(); }
	
	public static ILenBookService getILenBookServiceInstance(){ return new LenBookServiceImpl(); }
}
