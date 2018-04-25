package com.shawn.book.dao;

import java.util.Date;

import com.shawn.book.vo.LenBook;

public interface ILenBookDAO extends IDAO<Integer, LenBook> {
	
	/**
	 * 实现归还日期更新操作
	 * @param leid 表示要执行更新的数据主键
	 * @param retdate 更新日期
	 * @return
	 * @throws Exception
	 */
	boolean doUpdateByretdate(Integer leid,Date retdate) throws Exception;
	
}
