package com.shawn.book.service;

import java.util.List;

import com.shawn.book.vo.Item;

public interface IItemService {
	
	/**
	 * 实现分类的增加操作
	 * @param vo 表示要执行的vo对象
	 * @return 成功返回 true，失败返回 false
	 * @throws Exception
	 */
	public boolean insert(Item vo) throws Exception;
	
	/**
	 * 定义实现数据全部查询操作
	 * @return
	 * @throws Exception
	 */
	public List<Item> list() throws Exception;
	
}
