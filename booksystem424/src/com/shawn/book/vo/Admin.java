package com.shawn.book.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Admin implements Serializable {

	private static final long serialVersionUID = -6845906173685011649L;
	
	private String aid;
	
	private String password;
	
	private Date lastDate;
	
	private Integer flag;
	
	private Integer status;
	
	private List<Book> books;//一个管理员可以增加多本图书

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
