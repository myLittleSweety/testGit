package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public int deleteEmployeeById(Integer employeeId);

	public void updateEmployee(Employee employee);

	public List<Employee> getAllEmployees();
	
	public List<Employee> getEmployeesOfDept(Integer deptId);
}
