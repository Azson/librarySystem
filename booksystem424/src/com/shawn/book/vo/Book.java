package com.shawn.book.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Book implements Serializable{

	private static final long serialVersionUID = -8278701755290915625L;
	
	private Integer bid;
	
	private String name;
	
	private Date credate;
	
	private Integer status;
	
	private String note;
	
	private Item item; //表示一本书属于一个类别,iid
	
	private Admin admin; //表示图书由谁增加,aid
	
	private List<LenBook> lenBooks;//一本书有多条借书记录

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<LenBook> getLenBooks() {
		return lenBooks;
	}

	public void setLenBooks(List<LenBook> lenBooks) {
		this.lenBooks = lenBooks;
	}

}
