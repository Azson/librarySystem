package com.shawn.book.service;

import com.shawn.book.vo.Member;

public interface IMemberService {
	
	/**
	 * 实现数据增加操作
	 * @param vo 表示要增加的vo对象
	 * @return
	 * @throws Exception
	 */
	boolean insert(Member vo) throws Exception;
	
}
