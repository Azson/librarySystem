package com.shawn.book.service;

import java.util.Map;

import com.shawn.book.vo.LenBook;

public interface ILenBookService {
	
	/**
	 * 实现数据增加操作
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean insert(LenBook vo) throws Exception;
	
	/**
	 * 取得Book数据和Member表中的数据
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> listByMemberAndBooks() throws Exception;
	
	/**
	 * 实现分页操作
	 * @param column 要查询的列
	 * @param keyWord 查询关键字
	 * @param currentPage 当前页
	 * @param lineSize 每页行数
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> listBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception;
	
	/**
	 * 实现数据归还日期操作
	 * @param leid
	 * @return
	 * @throws Exception
	 */
	boolean updateByRetdate(Integer leid) throws Exception;
}
