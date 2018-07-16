package com.iotek.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iotek.ssm.dao.EmployeeDao;
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee employee) {
		employee.setCreateTime(new Date());
		employeeDao.insertEmployee(employee);
	}

	@Transactional
	@Override
	public int deleteEmployeeById(Integer employeeId) {
		return employeeDao.deleteEmployeeById(employeeId);
	}

	@Transactional
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Transactional
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.selectAllEmployees();
	}

	@Override
	public List<Employee> getEmployeesOfDept(Integer deptId) {
		return employeeDao.selectEmployeesByDeptId(deptId);
	}

}
