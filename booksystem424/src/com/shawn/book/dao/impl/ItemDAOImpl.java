package com.shawn.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.shawn.book.dao.AbstractDAOImpl;
import com.shawn.book.dao.IItemDAO;
import com.shawn.book.vo.Item;

public class ItemDAOImpl extends AbstractDAOImpl implements IItemDAO {

	public ItemDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean doCreate(Item vo) throws SQLException {
		String sql = "insert into item(name,note) values (?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getName());
		super.pstmt.setString(2, vo.getNote());
		int rel = super.pstmt.executeUpdate();
		return rel > 0;
	}

	@Override
	public boolean doUpdate(Item vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Item findById(Integer id) throws SQLException {
		Item vo = null;
		String sql = "select iid,name,note from item where iid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()){
			vo = new Item();
			vo.setIid(id);
			vo.setName(rs.getString("name"));
			vo.setNote(rs.getString("note"));
		}
		return vo;
	}

	@Override
	public List<Item> findAll() throws SQLException {
		List<Item> all = new ArrayList<Item>();
		String sql = "select iid,name,note from item";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Item vo = new Item();
			vo.setIid(rs.getInt("iid"));
			vo.setName(rs.getString("name"));
			vo.setNote(rs.getString("note"));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Item> findBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		return null;
	}

}
