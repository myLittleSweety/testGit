package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Employee;

public interface EmployeeDao {
	public void insertEmployee(Employee employee);

	public int deleteEmployeeById(Integer employeeId);

	public void updateEmployee(Employee employee);

	public List<Employee> selectAllEmployees();
	
	public List<Employee> selectEmployeesByDeptId(Integer deptId);
}
