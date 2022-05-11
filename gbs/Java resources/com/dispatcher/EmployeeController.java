package com.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Employee;


@Controller
public class EmployeeController {
	
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
		String message ="";
		System.out.println(employee);
//		String firstName = request.getParameter("firstName");
//		String middleName = request.getParameter("middleName");
//		String lastName = request.getParameter("lastName");
//		String birthDate = request.getParameter("birthDate");
//		String position = request.getParameter("position");
//		
//        
        ModelAndView mv = new ModelAndView();
        
		mv.setViewName("search.jsp");	
		mv.addObject("mssg","The employee was added successfully !");
		return mv;
	}
}

