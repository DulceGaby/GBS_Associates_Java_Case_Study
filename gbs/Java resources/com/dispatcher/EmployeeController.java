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
		 return "home";
	}
	
	@RequestMapping("/add-compensation")
	public String addCompensation() {
		 return "addCompensation";	
	}
	
	@RequestMapping("/search")
	public String employees(ModelMap model) {
		 List<Employee> employees = service.getEmployees();
		 model.addAttribute("employees", employees);
		 return "search";	
	}
	

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	 public String viewEmployee(@PathVariable("id") int id, ModelMap model) {
		  Employee employee = service.viewEmployee(id);
		  model.addAttribute("employee", employee);
		  return "../editEmployee";
	}
		
	public boolean dateValidation(String birthDate) throws ParseException {
		
		boolean validation = true;
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = formatter.parse(birthDate);
		
		//Getting the rest
		long diff = date.getTime() - newDate.getTime();
        TimeUnit time = TimeUnit.DAYS; 
        long days = time.convert(diff, TimeUnit.MILLISECONDS);
        
        if(days <6570) {
        	validation = false;
        }
		
		return validation;
	}
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public ModelAndView addEmployeeStore(@ModelAttribute("employee") Employee employee, HttpServletRequest request) throws ParseException {
		
		//Back-end validation
		//Request
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        
		boolean validation = true;
		String mssg="";
		
		//DATE VALIDATION
		validation = dateValidation(birthDate);
		if(validation == false)
			mssg = "Birth date should not be later than current date and must comply with legal validation. ";
		
        //EMPLOYEE VALIDATION
		
		ModelAndView mv = new ModelAndView();
		
		//Searching the database
		try {
			Employee oldEmployee = service.getEmployee(firstName, middleName, lastName, birthDate);
	        
	        if(oldEmployee != null) {
				mssg +="Employee "+firstName+" "+middleName+" "+lastName+" with date of birth: "+birthDate + " already exists.";
				validation = false;
			}  
		} catch (Exception e) {
			mv.setViewName("home");	
			mv.addObject("employee",employee);
			mv.addObject("mssg","Something went wrong please try again");
			return mv;
		}
		
		if(validation == true) {
			try {
				service.save(employee);				
				List<Employee> employees = service.getEmployees();
				
				mv.setViewName("search");	
				mv.addObject("employees",employees);
				mv.addObject("mssg","The employee was added successfully !");
				return mv;
			}catch(Exception e) {
				mv.setViewName("home");	
				mv.addObject("employee",employee);
				mv.addObject("mssg","Something went wrong please try again");
				return mv;
			}			
		}
		else {
			mv.setViewName("home");	
			mv.addObject("mssg",mssg);
			//Re-sending data for inputs to re write
			mv.addObject("employee",employee);
			return mv;
		}
	}


	@RequestMapping(value="/editEmployee", method=RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee, HttpServletRequest request) throws ParseException {
		
		//Back-end validation
		//Request
		System.out.println("EMPLEADO A EDITAR: "+request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        
		boolean validation = true;
		String mssg="";
		
		//DATE VALIDATION
		validation = dateValidation(birthDate);
		if(validation == false)
			mssg = "Birth date should not be later than current date and must comply with legal validation. ";
		
        //EMPLOYEE VALIDATION
		
		ModelAndView mv = new ModelAndView();
		
		//Searching the database
		try {
			Employee oldEmployee = service.getEmployee(firstName, middleName, lastName, birthDate);
	        
	        if(oldEmployee != null && oldEmployee.getId() != id) {
				mssg +="Employee "+firstName+" "+middleName+" "+lastName+" with date of birth: "+birthDate + " already exists.";
				validation = false;
			}  
		} catch (Exception e) {
			mv.setViewName("editEmployee");	
			mv.addObject("employee",employee);
			mv.addObject("mssg","Something went wrong please try again");
			return mv;
		}
				
		
		if(validation == true) {
			try {
				service.update(employee,id);				
				List<Employee> employees = service.getEmployees();
				
				mv.setViewName("search");	
				mv.addObject("employees",employees);
				mv.addObject("mssg","The employee was edited successfully !");
				return mv;
			}catch(Exception e) {
				mv.setViewName("editEmployee");	
				mv.addObject("employee",employee);
				mv.addObject("mssg","Something went wrong please try again 2");
				return mv;
			}			
		}
		else {
			mv.setViewName("editEmployee");	
			mv.addObject("mssg",mssg);
			Employee oldData = service.viewEmployee(id);
			//Re-sending data for the original employee
			mv.addObject("employee",oldData);
			return mv;
		}
	}
}

