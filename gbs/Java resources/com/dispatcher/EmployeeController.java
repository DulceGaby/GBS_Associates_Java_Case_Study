package com.dispatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
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
	public ModelAndView addEmployeeStore(@ModelAttribute("employee") Employee employee, HttpServletRequest request) throws ParseException {
		System.out.println(employee);
		
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
        
        
		ModelAndView mv = new ModelAndView();
		
		if(validation == true) {
//			Add try catch
			int result = service.save(employee);
			mv.setViewName("search.jsp");	
			mv.addObject("mssg","The employee was added successfully !"+result);
			return mv;
		}
		else {
			mv.setViewName("home.jsp");	
			mv.addObject("mssg",mssg);
			return mv;
		}
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

