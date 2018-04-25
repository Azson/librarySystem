package com.shawn.book.service.impl;

import com.shawn.book.dbc.DatabaseConnection;
import com.shawn.book.factory.DAOFactory;
import com.shawn.book.service.IMemberService;
import com.shawn.book.vo.Member;

public class MemberServiceImpl implements IMemberService {
	
	 private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean insert(Member vo) throws Exception {
		boolean flag = false;
		
		try{
			//表示mid数据不存在，可以增加
			if(DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findById(vo.getMid()) == null){
				DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
				flag = true;
			}
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
		
		return flag;
	}

}
