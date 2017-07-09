package com.pcp.innovation.mapper;

import org.apache.ibatis.annotations.Param;

import com.pcp.innovation.model.Employee;

public interface EmployeeMapper {

	public Employee selectEmployee(@Param(value = "emp_Id") Integer empId);
	
}
