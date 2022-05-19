package com.dispatcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Employee;
import com.services.EmployeeService;

@Controller
public class CompensationController {
	
	@Autowired
	private EmployeeService service;
	
	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}
	
	@RequestMapping("/add-compensation")
	public String addCompensation(ModelMap model) {
		 List<Employee> employees = service.getEmployees();
		 model.addAttribute("employees", employees);
		 return "addCompensation";	
	}
	
	@RequestMapping("/view-compensation")
	public String viewCompensation() {
		 return "compensationHistory";
	}

}
