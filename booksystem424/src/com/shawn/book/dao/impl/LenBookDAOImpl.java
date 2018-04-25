package com.shawn.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.shawn.book.dao.AbstractDAOImpl;
import com.shawn.book.dao.ILenBookDAO;
import com.shawn.book.vo.Book;
import com.shawn.book.vo.LenBook;
import com.shawn.book.vo.Member;

public class LenBookDAOImpl extends AbstractDAOImpl implements ILenBookDAO{

	public LenBookDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean doCreate(LenBook vo) throws SQLException {
		String sql = "insert into lenbook(bid,mid,credate) values(?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1,vo.getBook().getBid());
		super.pstmt.setString(2,vo.getMember().getMid());
		super.pstmt.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
		int rel = super.pstmt.executeUpdate();
		return rel > 0;
	}

	@Override
	public boolean doUpdate(LenBook vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public LenBook findById(Integer id) throws SQLException {
		return null;
	}

	@Override
	public List<LenBook> findAll() throws SQLException {
		return null;
	}

	@Override
	public List<LenBook> findBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		List<LenBook> all = new ArrayList<LenBook>();
		String sql = "select * from (select l.leid,b.name bname,m.name mname,l.credate,l.retdate from lenbook l,books b,member m where l.bid = b.bid and l.mid = m.mid and l."+column+" like ?) t order by t.credate desc limit ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%" + keyWord + "%");
		super.pstmt.setInt(2, (currentPage-1)*lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			LenBook vo = new LenBook();
			vo.setLeid(rs.getInt("leid"));
			Book book = new Book();
			book.setName(rs.getString("bname"));
			vo.setBook(book);
			Member member = new Member();
			member.setName(rs.getString("mname"));
			vo.setMember(member);
			vo.setCredate(rs.getTimestamp("credate"));
			vo.setRetdate(rs.getTimestamp("retdate"));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		String sql = "select count(leid) num from lenbook where " + column + " like ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()){
			int rel = rs.getInt("num");
			return rel;
		}
		return 0;
	}

	@Override
	public boolean doUpdateByretdate(Integer leid, Date retdate)
			throws Exception {
		String sql = "update lenbook set retdate = ? where leid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setTimestamp(1, new java.sql.Timestamp(retdate.getTime()));
		super.pstmt.setInt(2, leid);
		int rel = super.pstmt.executeUpdate();
		return rel > 0;
	}

}
