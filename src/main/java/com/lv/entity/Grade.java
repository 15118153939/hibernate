package com.lv.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int gid;
	private String gname;
	private String gdesc;
	
//	一方 定义 一个多方的集合
	private Set<Student> students = new HashSet<Student>();
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	public Grade(int gid, String gname, String gdesc) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}
	public Grade() {
		super();
	}

	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Grade(int gid, String gname, String gdesc, Set<Student> students) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.students = students;
	}
	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", gdesc=" + gdesc + ", student=" + students + "]";
	}
	
	
	
	
}
