package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Dept;

public interface DeptDao {
	public List<Dept> selectAllDept();
	
	public Dept selectDeptById(Integer deptId);
}
