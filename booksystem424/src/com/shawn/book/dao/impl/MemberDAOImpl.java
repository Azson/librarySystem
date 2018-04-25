package com.shawn.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.shawn.book.dao.AbstractDAOImpl;
import com.shawn.book.dao.IMemberDAO;
import com.shawn.book.vo.Member;

public class MemberDAOImpl extends AbstractDAOImpl implements IMemberDAO {

	public MemberDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql = "insert into member(mid,name,age,sex,phone) values(?,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setString(2, vo.getName());
		super.pstmt.setInt(3, vo.getAge());
		super.pstmt.setInt(4, vo.getSex());
		super.pstmt.setString(5, vo.getPhone());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Member findById(String id) throws SQLException {
		Member vo = null;
		String sql = "select mid,name,age,sex,phone from member where mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()){
			vo = new Member();
			vo.setMid(id);
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("age"));
			vo.setSex(rs.getInt("sex"));
			vo.setPhone(rs.getString("phone"));
		}
		return vo;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		List<Member> all = new ArrayList<Member>();
		String sql = "select mid,name from member";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Member vo = new Member();
			vo.setMid(rs.getString("mid"));
			vo.setName(rs.getString("name"));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Member> findBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		return null;
	}

}
