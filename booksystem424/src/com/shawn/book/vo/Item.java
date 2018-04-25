package com.shawn.book.vo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{

	private static final long serialVersionUID = -4636382478630832561L;

	private Integer iid;
	
	private String name;
	
	private String note;
	
	private List<Book> books;	//表示一个类别下有多本书
	
	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
