package com.lv.entity;

import java.sql.Blob;
import java.util.Date;

/**
 * ѧ����
 * @author lvmin
 * 
 * java bean ���㣺
 * 1�����е���
 * 2.�ṩ�в���������Ĭ�Ϲ������
 * 3������˽��
 * 4����Ϥset,get/��װ
 *
 */
public class Students {
	private int sid;//ѧ��
	private String sname;//����
	private String gender;//�Ա�
	private Date birthday;//��������
//	private String address;//��ַ
	
	
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
