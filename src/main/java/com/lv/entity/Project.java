package com.lv.entity;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private int proid;
	private String proname;

//	添加一个员工的集合
	private Set<Employee> employees = new HashSet<Employee>();

	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname + ", employees=" + employees + "]";
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Project(int proid, String proname, Set<Employee> employees) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.employees = employees;
	}

	public Project() {
		super();
	}

	public Project(int proid, String proname) {
		super();
		this.proid = proid;
		this.proname = proname;
	}

}
