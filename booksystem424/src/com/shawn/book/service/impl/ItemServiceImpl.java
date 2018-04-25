package com.shawn.book.service.impl;

import java.util.List;

import com.shawn.book.dbc.DatabaseConnection;
import com.shawn.book.factory.DAOFactory;
import com.shawn.book.service.IItemService;
import com.shawn.book.vo.Item;

public class ItemServiceImpl implements IItemService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean insert(Item vo) throws Exception {
		boolean flag = false;
		try{
			DAOFactory.getIItemDAOInstance(this.dbc.getConn()).doCreate(vo);
			flag = true;
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Item> list() throws Exception {
		try{
			return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll();
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
	}

}
