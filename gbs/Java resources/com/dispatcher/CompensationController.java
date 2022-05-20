package com.dispatcher;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Compensation;
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
	
	@RequestMapping(value="/addCompensation", method=RequestMethod.POST)
	public ModelAndView addCompensationStore(@ModelAttribute("employee") Compensation compensation, HttpServletRequest request) throws ParseException {
		
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		String mssg = "";
		System.out.println(compensation);
		
		//COMPENSATION VALIDATION
		if(type.equals("Salary")) {
			//Check if there is not another compensation in the same month
			mssg = "Only one salary entry per employee per month can be added. ";
		}
		else if (type.equals("Adjustment")) {
			//Check if the amount is different than zero
			mssg = "Amount can be any value except zero. ";
			//Check if there is a description
			mssg += "Description is required. ";
		}
		else {
			//Check if the amount is greater than zero
			mssg = "Amount should be greater than zero. ";
			//Check if there is a description
			mssg += "Description is required. ";
		}
		
		ModelAndView mv = new ModelAndView();
		List<Employee> employees = service.getEmployees();
		Employee employee = service.viewEmployee(idEmployee);
		
		if(mssg == "") {
			try {
				//service.update(employee,id);				
				
				mv.setViewName("compensationHistory");	
				mv.addObject("mssg","The compensation was added successfully !");
				
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
