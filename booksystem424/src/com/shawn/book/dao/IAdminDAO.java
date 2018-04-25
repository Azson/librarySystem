package com.shawn.book.dao;

import com.shawn.book.vo.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	
	/**
	 * 实现用户登录检查操作
	 * @param vo 表示要执行检查的对象（aid,password,flag）
	 * @return 成功返回 ture,失败返回 false
	 * @throws Exception
	 */
	public boolean findLogin(Admin vo) throws Exception;
	
	/**
	 * 实现用数据更新操作
	 * @param aid 要更新的主键
	 * @return
	 * @throws Exception
	 */
	public boolean doUpdateByLastDate(String aid) throws Exception;
}
