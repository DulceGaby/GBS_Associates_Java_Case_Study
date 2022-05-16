package com.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Employee;
import com.services.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping("/add-employee")
	public String addEmployee() {
		 return "home.jsp";
	}
	
	@RequestMapping("/add-compensation")
	public String addCompensation() {
		 return "addCompensation.jsp";	
	}
	
	@RequestMapping("/search")
	public String employees() {
		 return "search.jsp";	
	}
	
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public ModelAndView addEmployeeStore(@ModelAttribute("employee") Employee employee) {
		System.out.println("ESTOY EN EL CONTROLADOR DE EMPLOYEE");
		System.out.println(employee);
		
		int result = service.save(employee);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search.jsp");	
		mv.addObject("mssg","The employee was added successfully !"+result);
		
		
		return mv;
	}
	
	@RequestMapping("validateFirstName")
	public @ResponseBody String validateFirstName(@RequestParam("firstName") String firstName) {
		String mssg ="";
		Employee employee = service.getEmployee(firstName);
		
		if(employee != null) {
			mssg="El nombre ya existe";
		}
		System.out.println("BANDERA CONTROLADOR "+mssg);
		return mssg;		
		
	}
}

