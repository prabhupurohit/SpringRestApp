package com.pcp.innovation.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcp.innovation.model.EmployeeDetail;
import com.pcp.innovation.service.EmployeeService;
import com.pcp.innovation.service.EmployeeServiceImpl;

/**
 Employee controller
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController 
{
	public static final Logger LOGGER = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService empServ;
    
	@RequestMapping("/{empId}")
	public EmployeeDetail getEmployeeDetailsWithId()
    {
		EmployeeDetail empDtl = null;
    	try {
    		LOGGER.info( "Get Employee and Department details for EMP_ID: 101" );
    		empDtl = empServ.getEmployeeDetail(101);
    		LOGGER.info("Emp ID: " + empDtl.getEmpId());
    		LOGGER.info("Emp Dept Id: " + empDtl.getDeptId());
    		LOGGER.info("Emp Desgn: " + empDtl.getDesgn());
    	} catch (Exception e) {
    		LOGGER.error("Exception occured: " + e.getMessage());
    	}
    	return empDtl;
    }
}
