package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iotek.ssm.dao.DeptDao;
import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
	@Transactional
	@Override
	public List<Dept> getAllDepts() {
		return deptDao.selectAllDept();
	}

}
