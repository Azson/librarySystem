package com.shawn.book.service;

import com.shawn.book.vo.Admin;

public interface IAdminService {
	
	/**
	 * 实现管理员登录检查操作，调用IAdminDAO接口中的findLogin方法
	 * @param vo 表示要操作的对象（aid,password）
	 * @return 成功返回true并且将最后一次登陆日期传递到页面，失败返回false
	 * @throws Exception
	 */
	boolean login(Admin vo) throws Exception;
	
	/**
	 * 实现增加操作
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean insert(Admin vo) throws Exception;
	
}
