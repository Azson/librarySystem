package com.shawn.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.shawn.book.dao.AbstractDAOImpl;
import com.shawn.book.dao.IBookDAO;
import com.shawn.book.vo.Admin;
import com.shawn.book.vo.Book;
import com.shawn.book.vo.Item;

public class BookDAOImpl extends AbstractDAOImpl implements IBookDAO {

	public BookDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean doCreate(Book vo) throws SQLException {
		String sql = "insert into books(iid,aid,name,credate,status,note) values(?,?,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, vo.getItem().getIid());
		super.pstmt.setString(2, vo.getAdmin().getAid());
		super.pstmt.setString(3, vo.getName());
		super.pstmt.setTimestamp(4, new java.sql.Timestamp(vo.getCredate().getTime()));
		super.pstmt.setInt(5, vo.getStatus());
		super.pstmt.setString(6, vo.getNote());
		int rel = super.pstmt.executeUpdate();
		return rel > 0;
	}

	@Override
	public boolean doUpdate(Book vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Book findById(Integer id) throws SQLException {
		return null;
	}

	@Override
	public List<Book> findAll() throws SQLException {
		List<Book> all = new ArrayList<Book>();
		String sql = "select bid,name from books";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setName(rs.getString("name"));
			all.add(book);
		}
		return all;
	}

	@Override
	public List<Book> findBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		List<Book> all = new ArrayList<Book>();
		String sql = "select * from "
				+ "(select b.bid,b.name,i.name iname,b.aid,b.credate,b.status,b.note "
					+ "from books b,admin a,item i where b.iid = i.iid and b.aid = a.aid and b."+column+" like ?) t"
					+ " order by t.bid limit ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%" + keyWord + "%");
		super.pstmt.setInt(2, (currentPage - 1)*lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Book vo = new Book();
			vo.setBid(rs.getInt("bid"));
			vo.setCredate(rs.getTimestamp("credate"));
			vo.setName(rs.getString("name"));
			vo.setNote(rs.getString("note"));
			vo.setStatus(rs.getInt("status"));
			Item item = new Item();
			item.setName(rs.getString("iname"));
			vo.setItem(item);
			Admin admin = new Admin();
			admin.setAid(rs.getString("aid"));
			vo.setAdmin(admin);
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		String sql = "select count(name) num from books where " + column + " like ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()){
			int rel = rs.getInt("num");
			return rel;
		}
		return 0;
	}

}
