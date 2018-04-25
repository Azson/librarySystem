package com.shawn.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.shawn.book.dao.AbstractDAOImpl;
import com.shawn.book.dao.IAdminDAO;
import com.shawn.book.vo.Admin;

public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO{

	public AdminDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean doCreate(Admin vo) throws SQLException {
		String sql = "insert into admin(aid,password,status) values(?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getAid());
		super.pstmt.setString(2, vo.getPassword());
//		super.pstmt.setTimestamp(3, new java.sql.Timestamp(vo.getLastDate().getTime()));
		super.pstmt.setInt(3, vo.getStatus());
		int rel = super.pstmt.executeUpdate();
		return rel > 0;
	}

	@Override
	public boolean doUpdate(Admin vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Admin findById(String id) throws SQLException {
		Admin vo = null;
		String sql = "select aid,password,lastdate,flag,status from admin where aid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()){
			vo = new Admin();
			vo.setAid(rs.getString("aid"));
			vo.setFlag(rs.getInt("flag"));
			vo.setStatus(rs.getInt("status"));
			vo.setPassword(rs.getString("password"));
			vo.setLastDate(rs.getTimestamp("lastdate"));
		}
		return vo;
	}

	@Override
	public List<Admin> findAll() throws SQLException {
		List<Admin> all = new ArrayList<Admin>();
		String sql = "select aid,password,lastdate,flag,status from admin";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Admin vo = new Admin();
			vo.setAid(rs.getString("aid"));
			vo.setPassword(rs.getString("password"));
			vo.setLastDate(rs.getTimestamp("lastdate"));
			vo.setFlag(rs.getInt("flag"));
			vo.setStatus(rs.getInt("status"));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Admin> findBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		return null;
	}

	@Override
	public boolean findLogin(Admin vo) throws Exception {
		boolean flag = false;
		String sql = "select lastdate,flag from admin where aid=? and password=? and status=1";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getAid());
		super.pstmt.setString(2, vo.getPassword());
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()){
			flag = true;
			vo.setLastDate(rs.getTimestamp("lastdate"));//设置lastdate
			vo.setFlag(rs.getInt("flag"));
		}
		return flag;
	}

	@Override
	public boolean doUpdateByLastDate(String aid)
			throws Exception {
		boolean flag = false;
		String sql = "update admin set lastdate = ? where aid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		//登陆成功后，使用当前日期为最后一次登陆日期
		super.pstmt.setTimestamp(1, new Timestamp(new Date().getTime()));
		super.pstmt.setString(2, aid);
		int rel = super.pstmt.executeUpdate();
		if(rel > 0){
			flag = true;
		}
		return flag;
	}

}
