package com.shawn.book.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.shawn.book.dbc.DatabaseConnection;
import com.shawn.book.factory.DAOFactory;
import com.shawn.book.service.IBookService;
import com.shawn.book.vo.Book;

public class BookServiceImpl implements IBookService {
	DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean insert(Book vo) throws Exception {
		try{
			return DAOFactory.getIBookDAOInstance(this.dbc.getConn()).doCreate(vo);
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> findByAdminAndItem() throws Exception {
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("allAdmins", DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findAll());
			map.put("allItems", DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll());
			return map;
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> listBySplit(String column, String keyWord,
			int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = null;
		try{
			map = new HashMap<String, Object>();
			map.put("allBook", DAOFactory.getIBookDAOInstance(this.dbc.getConn()).findBySplit(column, keyWord, currentPage, lineSize));
			map.put("allRecord", DAOFactory.getIBookDAOInstance(this.dbc.getConn()).getAllCount(column, keyWord));
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
		return map;
	}

}
