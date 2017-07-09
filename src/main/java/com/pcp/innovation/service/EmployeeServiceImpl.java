package com.pcp.innovation.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcp.innovation.dao.EmployeeDao;
import com.pcp.innovation.model.Employee;
import com.pcp.innovation.model.EmployeeDetail;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;
	
	public static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	
	public EmployeeDetail getEmployeeDetail(int empId) {
		
		EmployeeDetail empDtl = null;
		try {
			empDtl = new EmployeeDetail();
			Employee emp = empDao.getEmployee(empId);
			if (emp !=null) {
				empDtl.setEmpId(emp.getEmpId());
				empDtl.setDeptId(emp.getDeptId());
				empDtl.setDesgn(emp.getDesgn());
			}
		} catch (Exception e) {	
			LOGGER.error("Exception ocuured: " + e.getMessage());
		}
		return empDtl;
	}
}
