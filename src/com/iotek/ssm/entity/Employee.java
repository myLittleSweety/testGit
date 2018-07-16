package com.iotek.ssm.entity;

import java.util.Date;
import java.util.List;

public class Employee {
	private int employeeId;
	private String lastname;
	private String email;
	private Date birth;
	private Date createTime;
	private Dept dept;
	

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	


	public Employee(String lastname, String email, Date birth, Date createTime, Dept dept) {
		super();
		this.lastname = lastname;
		this.email = email;
		this.birth = birth;
		this.createTime = createTime;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", lastname=" + lastname + ", email=" + email + ", birth=" + birth
				+ ", createTime=" + createTime + ", dept=" + dept + "]";
	}

}
