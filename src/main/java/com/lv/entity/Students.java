package com.lv.entity;

import java.sql.Blob;
import java.util.Date;

/**
 * 学生类
 * @author lvmin
 * 
 * java bean 满足：
 * 1：公有的类
 * 2.提供有不带参数的默认构造防范
 * 3：属性私有
 * 4：熟悉set,get/封装
 *
 */
public class Students {
	private int sid;//学号
	private String sname;//姓名
	private String gender;//性别
	private Date birthday;//出生日期
//	private String address;//地址
	
	
	private Address address;
	
	



	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Students(int sid, String sname, String gender, Date birthday, Address address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}


	public Students() {
		super();
	}
	
	
	
}
