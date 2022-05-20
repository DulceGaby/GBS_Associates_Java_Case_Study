package com.dispatcher;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Compensation;
import com.dto.Employee;
import com.services.CompensationService;
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
	
	@Autowired
	private CompensationService cservice;
	
	public CompensationService getCservice() {
		return cservice;
	}

	public void setCservice(CompensationService cservice) {
		this.cservice = cservice;
	}

	@RequestMapping("/add-compensation")
	public String addCompensation(ModelMap model) {
		 List<Employee> employees = service.getEmployees();
		 model.addAttribute("employees", employees);
		 return "addCompensation";	
	}
	
	@RequestMapping(value = "/view-compensation/{id}", method = RequestMethod.GET)
	 public String viewCompensation(@PathVariable("id") int id, ModelMap model) {
		  List<Compensation> compensations = cservice.getCompensationPerEmployee(id);
		  boolean records = compensations.isEmpty();
		  Employee employee = service.viewEmployee(id);
		  String mssg="", recordDate, recordYear, recordMonth;
		  
		  if(records == true) {
			  mssg="Nothing to show";
			  model.addAttribute("mssg", mssg);
		  }
		  else {
			  //Agrupar por mes
			  
			  for (Compensation comp : compensations) {
					recordDate = comp.getDate();
					recordYear = recordDate.substring(0,4);
					recordMonth = recordDate.substring(5,7);
//					Arreglo de años, con meses y monto
			  }
			  
			  
			  
			  System.out.println(compensations+"aaa");
			  model.addAttribute("compensations", compensations);
			  model.addAttribute("employee", employee);
		  }
		  
		  return "../compensationHistory";
	}
	
	@RequestMapping(value="/addCompensation", method=RequestMethod.POST)
	public ModelAndView addCompensationStore(@ModelAttribute("employee") Compensation compensation, HttpServletRequest request) throws ParseException {
		
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		String recordDate, recordYear, recordMonth, dateYear, dateMonth;
		dateYear = date.substring(0,4);
		dateMonth = date.substring(5,7);
		
		String mssg = "";
		
		//COMPENSATION VALIDATION
		if(type.equals("Salary")) {
			//Check if there is not another compensation in the same month
			List<Compensation> compensations = cservice.getCompensationPerEmployee(idEmployee);
			boolean records = compensations.isEmpty();
			
			if(records == false) {
				//Check for each date, year and month only
				System.out.println(compensations);
				
				for (Compensation comp : compensations) {
					recordDate = comp.getDate();
					recordYear = recordDate.substring(0,4);
					recordMonth = recordDate.substring(5,7);
					
					if(dateYear.equals(recordYear))
						if(dateMonth.equals(recordMonth))
							mssg = "Only one salary entry per employee per month can be added. ";
				}
			}		
		}
		else if (type.equals("Adjustment")) {
			//Check if the amount is different than zero
			if(amount == 0)
				mssg = "Amount can be any value except zero. ";
			//Check if there is a description
			if(description == "")
				mssg += "Description is required. ";
		}
		else {
			//Check if the amount is greater than zero
			if(amount <= 0)
				mssg = "Amount should be greater than zero. ";
			//Check if there is a description
			if(description == "")
				mssg += "Description is required. ";
		}
		
		ModelAndView mv = new ModelAndView();
		List<Employee> employees = service.getEmployees();
		Employee employee = service.viewEmployee(idEmployee);
		
		if(mssg == "") {
			try {		
				cservice.save(compensation);
				mv.setViewName("search");	
				mv.addObject("employees",employees);
				mv.addObject("mssg","The compensation was added successfully!");
				
			}catch(Exception e) {
				
				mv.setViewName("addCompensation");	
				mv.addObject("mssg","Something went wrong please try again");
				mv.addObject("employees",employees);
				mv.addObject("employee",employee);
				mv.addObject("compensation",compensation);
			}
		}
		else {
			mv.setViewName("addCompensation");	
			mv.addObject("mssg",mssg);
			mv.addObject("employees",employees);
			mv.addObject("employee",employee);
			mv.addObject("compensation",compensation);
		}

		return mv;
	}
}
