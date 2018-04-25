package com.shawn.book.vo;

import java.io.Serializable;
import java.util.Date;

public class LenBook implements Serializable{

	private static final long serialVersionUID = -4708602007932105766L;

	/**
	 * 借书编号
	 */
	private Integer leid;
	
	/**
	 * 借书记录对应的图书
	 */
	private Book book;
	
	/**
	 * 用户ID
	 */
	private Member member;
	
	/**
	 * 借书日期
	 */
	private Date credate;
	
	/**
	 * 图书归还日期
	 */
	private Date retdate;

	public Integer getLeid() {
		return leid;
	}

	public void setLeid(Integer leid) {
		this.leid = leid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public Date getRetdate() {
		return retdate;
	}

	public void setRetdate(Date retdate) {
		this.retdate = retdate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
