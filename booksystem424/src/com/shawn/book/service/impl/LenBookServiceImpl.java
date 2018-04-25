package com.shawn.book.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.shawn.book.dbc.DatabaseConnection;
import com.shawn.book.factory.DAOFactory;
import com.shawn.book.service.ILenBookService;
import com.shawn.book.vo.LenBook;

public class LenBookServiceImpl implements ILenBookService {
	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean insert(LenBook vo) throws Exception {
		try{
			return DAOFactory.getILenBookDAOInstance(this.dbc.getConn()).doCreate(vo);
		} catch(Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> listByMemberAndBooks() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try{
			map.put("allBooks", DAOFactory.getIBookDAOInstance(this.dbc.getConn()).findAll());
			map.put("allMembers", DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findAll());
			return map;
		} catch(Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> listBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("allLenBooks", DAOFactory.getILenBookDAOInstance(this.dbc.getConn()).findBySplit(column, keyWord, currentPage, lineSize));
			map.put("allRecord", DAOFactory.getILenBookDAOInstance(this.dbc.getConn()).getAllCount(column, keyWord));
			return map;
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean updateByRetdate(Integer leid) throws Exception {
		try{
			return DAOFactory.getILenBookDAOInstance(this.dbc.getConn()).doUpdateByretdate(leid, new Date());
		} catch(Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
