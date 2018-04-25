package com.shawn.book.vo;

import java.io.Serializable;
import java.util.List;

public class Member implements Serializable{

	private static final long serialVersionUID = -7004499317697993203L;

	private String mid;
	
	private String name;
	
	private Integer age;
	
	private Integer sex;
	
	private String phone;
	
	private List<LenBook> lenBooks;//一个人可以借多本书

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<LenBook> getLenBooks() {
		return lenBooks;
	}

	public void setLenBooks(List<LenBook> lenBooks) {
		this.lenBooks = lenBooks;
	}
	
}
