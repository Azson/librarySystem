package com.shawn.book.service.impl;

import com.shawn.book.dbc.DatabaseConnection;
import com.shawn.book.factory.DAOFactory;
import com.shawn.book.service.IAdminService;
import com.shawn.book.vo.Admin;

public class AdminServiceImpl implements IAdminService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean login(Admin vo) throws Exception {
		try{
			if(DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findLogin(vo)){
				return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doUpdateByLastDate(vo.getAid());
			}
			return false;
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();//最后一定要关闭数据库连接
		}
	}

	@Override
	public boolean insert(Admin vo) throws Exception {
		try{
			if(DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findById(vo.getAid()) == null){
				DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doCreate(vo);
				return true;
			}
		} catch(Exception e){
			throw e;
		} finally{
			this.dbc.close();
		}
		return false;
	}

}
