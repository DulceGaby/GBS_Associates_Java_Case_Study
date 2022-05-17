package com.dispatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String employees(ModelMap model) {
		 List<Employee> employees = service.getEmployees();
		 model.addAttribute("employees", employees);
		 return "search.jsp";	
	}
	
	
	@RequestMapping("/employee/{id}")
	 public String viewEmployee(@PathVariable("id") int id) {
	  System.out.println("Bandera controlador");
	  return "editEmployee.jsp";
	 }
	
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public ModelAndView addEmployeeStore(@ModelAttribute("employee") Employee employee, HttpServletRequest request) throws ParseException {
		
		//Back-end validation
		boolean validation = true;
		String mssg="";
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String birthDate = request.getParameter("birthDate");
		Date newDate = formatter.parse(birthDate);
		
		//Getting the rest
		long diff = date.getTime() - newDate.getTime();
        TimeUnit time = TimeUnit.DAYS; 
        long days = time.convert(diff, TimeUnit.MILLISECONDS);
        
        if(days <6570) {
        	validation = false;
        	mssg = "Birth date should not be later than current date and must comply with legal validation.";
        }
        
        //Name + middle + last name validation
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        
        
        Employee oldEmployee = service.getEmployee(firstName);
        if(oldEmployee != null) {
			mssg +=" Employee already exists";
			validation = false;
		}
        
        
		ModelAndView mv = new ModelAndView();
		
		if(validation == true) {
			try {
				service.save(employee);
				mv.setViewName("search.jsp");	
				mv.addObject("mssg","The employee was added successfully !");
				return mv;
			}catch(Exception e) {
				mv.setViewName("home.jsp");	
				mv.addObject("mssg","Something went wrong please try again");
				return mv;
			}			
		}
		else {
			mv.setViewName("home.jsp");	
			mv.addObject("mssg",mssg);
			return mv;
		}
	}
}

