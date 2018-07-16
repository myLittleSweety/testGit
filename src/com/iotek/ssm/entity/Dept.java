package com.iotek.ssm.entity;

import java.util.List;

public class Dept {
	private int deptId;
	private String name;
	private List<Employee> employees;

	public Dept() {
		super();
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dept(String name) {
		super();
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", name=" + name + ", employees=" + employees + "]";
	}

	

}
