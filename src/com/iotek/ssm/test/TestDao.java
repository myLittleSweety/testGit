package com.iotek.ssm.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iotek.ssm.dao.DeptDao;
import com.iotek.ssm.dao.EmployeeDao;
import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Employee;

// 启动时加载SpringIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
// 引入Spring的配置文件
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class TestDao {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void testQueryAllDepts() {
		List<Dept> depts = deptDao.selectAllDept();
		System.out.println(depts);
	}

	@Test
	public void testQueryAllEmployees() {
		List<Employee> employees = employeeDao.selectAllEmployees();
		System.out.println(employees);
	}
	
	@Test
	public void testQueryDeptById() {
		Dept dept = deptDao.selectDeptById(2);
		System.out.println(dept);
	}
	
	@Test
	public void testSelectEmployeesByDeptId() {
		List<Employee> employees = employeeDao.selectEmployeesByDeptId(2);
		System.out.println(employees);
	}

}