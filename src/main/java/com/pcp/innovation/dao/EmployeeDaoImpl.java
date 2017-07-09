package com.pcp.innovation.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcp.innovation.mapper.EmployeeMapper;
import com.pcp.innovation.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	public static final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public Employee getEmployee(int empId) {
	
		Employee emp = null;
		
		try {	
			emp = employeeMapper.selectEmployee(empId);
		}
		catch (Exception e1) {
			LOGGER.error("Exception occured: " + e1.getMessage());
			e1.printStackTrace();
		}
		return emp;
	}
		
}
