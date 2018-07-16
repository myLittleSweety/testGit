package com.iotek.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iotek.ssm.dao.EmployeeDao;
import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.EmployeeService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DeptService deptService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list";
	}

	@RequestMapping("/addPage")
	public String addPage(Model model) {
		List<Dept> depts = deptService.getAllDepts();
		System.out.println(depts);
		model.addAttribute("depts", depts);
		return "addPage";
	}

	@RequestMapping(value = "/editPage/{employeeId}", method = RequestMethod.GET)
	public String editPage(Model model, @PathVariable("employeeId") Integer employeeId) {
		List<Dept> depts = deptService.getAllDepts();
		System.out.println(depts);
		model.addAttribute("depts", depts);
		model.addAttribute("employeeId", employeeId);
		return "editPage";
	}

	@RequestMapping("/add")
	public String add(Employee employee, Model model) {
		employeeService.addEmployee(employee);
		return list(model);
	}

	@RequestMapping("/edit")
	public String edit(Employee employee, Model model) {
		employeeService.updateEmployee(employee);
		return list(model);
	}

	@RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@PathVariable("employeeId") Integer employeeId) {
		int res = employeeService.deleteEmployeeById(employeeId);
		return res > 0 ? "success" : "error";
	}

	@RequestMapping("selectEmployee")
	public String selectEmployee(Model model) {
		List<Dept> depts = deptService.getAllDepts();
		model.addAttribute("depts", depts);
		return "selectEmployee";
	}

	@RequestMapping(value = "/getEmployees/{deptId}", method = RequestMethod.POST)
	@ResponseBody
	public String getEmployees(@PathVariable("deptId") Integer deptId) {
		List<Employee> employees = employeeService.getEmployeesOfDept(deptId);
		String json = JSON.toJSONString(employees);
		return json;
	}

}
