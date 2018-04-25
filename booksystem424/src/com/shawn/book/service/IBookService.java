package com.shawn.book.service;

import java.util.Map;

import com.shawn.book.vo.Book;

public interface IBookService {
	
	/**
	 * 增加图书详情
	 * @param vo 表示要进行数据增加的对象
	 * @return 成功返回 true，失败返回 false
	 * @throws Exception
	 */
	public boolean insert(Book vo) throws Exception;
	
	/**
	 * 此方法表示执行查询admin表和item表中的全部数据
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findByAdminAndItem() throws Exception;
	
	/**
	 * 调用分页接口类
	 * @param column 列名
	 * @param keyword 查询关键字
	 * @param currentPage 当前页
	 * @param lineSize 每页的记录数
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> listBySplit(String column,String keyword,int currentPage,int lineSize) throws Exception;
	
}
