package com.dispatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.dto.CompensationOrg;
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
	
	@RequestMapping("/edit-compensation/{id}")
	public String editCompensation(@PathVariable("id") int id, ModelMap model) {
		 Compensation compensation = cservice.findCompensation(id);
		 Employee employee = service.viewEmployee(compensation.getIdEmployee());
		 model.addAttribute("compensation", compensation);
		 model.addAttribute("employee", employee);
		 return "../editCompensation";	
	}
	
	@RequestMapping(value = "/view-compensation-month-search/{id}", method = RequestMethod.GET)
	 public String viewCompensationSearch(@PathVariable("id") int id, ModelMap model, HttpServletRequest request) throws ParseException {
		List<Compensation> compensations = cservice.getCompensationsEmployee(id);
		boolean records = compensations.isEmpty();
		Employee employee = service.viewEmployee(id);
		String mssg="", recordDate, recordYear, recordMonth;
		List<CompensationOrg> compensationsMonth = new ArrayList<>();
		
		int monthStart=0, monthEnd=0, yearStart=0, yearEnd=0;
		//START DATE
		if(!request.getParameter("start-date").equals("")) {
			if(request.getParameter("start-date").substring(5,7).charAt(0) == '0')
				monthStart = Integer.parseInt(request.getParameter("start-date").substring(6,7));
			else
				monthStart = Integer.parseInt(request.getParameter("start-date").substring(5,7));
			
				yearStart = Integer.parseInt(request.getParameter("start-date").substring(0,4));
		}
		//END DATE
		if(!request.getParameter("end-date").equals("")) {
			if(request.getParameter("end-date").substring(5,7).charAt(0) == '0')
				monthEnd = Integer.parseInt(request.getParameter("end-date").substring(6,7));
			else
				monthEnd = Integer.parseInt(request.getParameter("end-date").substring(5,7));
			
				yearEnd = Integer.parseInt(request.getParameter("end-date").substring(0,4));
		}  
		if(records == true) {
			mssg="0 results found";
			model.addAttribute("mssg", mssg);
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart = formatter.parse(yearStart+"-"+monthStart+"-"+"01");
			Date dateEnd = formatter.parse(yearEnd+"-"+monthEnd+"-"+"01");
			//Group by month and year
			for (Compensation comp : compensations) {
				recordDate = comp.getDate();
				recordYear = recordDate.substring(0,4);
				recordMonth = recordDate.substring(5,7);
				Date recordDateN = formatter.parse(recordYear+"-"+(recordMonth)+"-"+"01");
					
				//Case 0
				if(compensationsMonth.isEmpty() == true) {
					boolean initial = false;
					
					if(monthStart != 0 && yearStart !=0 && monthEnd == 0 && yearEnd == 0) {
						if(recordDateN.after(dateStart) == true)
							initial = true;
					}
					else if(monthStart == 0 && yearStart ==0 && monthEnd != 0 && yearEnd != 0) {
						if(recordDateN.before(dateEnd) == true)
							initial = true;
					}
					else {
						if(yearStart ==  yearEnd) {
							if((Integer.parseInt(recordMonth) >= monthStart) && (Integer.parseInt(recordYear) == yearStart) && (Integer.parseInt(recordMonth) <= monthEnd)) {
								initial = true;
							}
						}
						else {
							if(recordDateN.after(dateStart) && recordDateN.before(dateEnd) == true)
								initial = true;
						}
					}
						
					
					if(initial == true)		
						compensationsMonth.add(new CompensationOrg(recordMonth, monthText(recordMonth), recordYear, comp.getAmount()));
				}
				else {
					boolean add = false;
					for (CompensationOrg compensationOrg : compensationsMonth) {
						if(compensationOrg.getMonth().equals(recordMonth) && compensationOrg.getYear().equals(recordYear)) {
							compensationOrg.setAmount(compensationOrg.getAmount() + comp.getAmount());
						}
						else {
							if(monthStart != 0 && yearStart !=0 && monthEnd == 0 && yearEnd == 0) {
								if(recordDateN.after(dateStart) == true)
									add = true;
							}
							else if(monthStart == 0 && yearStart ==0 && monthEnd != 0 && yearEnd != 0) {
								if(recordDateN.before(dateEnd) == true)
									add = true;
							}
							else {
								if(yearStart ==  yearEnd) {
									if((Integer.parseInt(recordMonth) >= monthStart) && (Integer.parseInt(recordYear) == yearStart) && (Integer.parseInt(recordMonth) <= monthEnd)) {
										add = true;
									}
								}
								else {
									if(recordDateN.after(dateStart) && recordDateN.before(dateEnd) == true)
										add = true;
								}
							}
						}
					}
					if(add == true)
						//Adding the new info
						compensationsMonth.add(new CompensationOrg(recordMonth, monthText(recordMonth), recordYear, comp.getAmount()));
					}					
			  	}
			    model.addAttribute("compensations", compensationsMonth);
			    model.addAttribute("start", request.getParameter("start-date"));
			    model.addAttribute("end", request.getParameter("end-date"));
		  }
		  model.addAttribute("employee", employee);
		  return "../compensationHistory";
	}
	
	@RequestMapping(value = "/view-compensation/{id}")
	 public String viewCompensation(@PathVariable("id") int id, ModelMap model) {
		  List<Compensation> compensations = cservice.getCompensationsEmployee(id);
		  boolean records = compensations.isEmpty();
		  Employee employee = service.viewEmployee(id);
		  String mssg="", recordDate, recordYear, recordMonth;
		  List<CompensationOrg> compensationsMonth = new ArrayList<>();
		  
		  
		  if(records == true) {
			  mssg="0 results found";
			  model.addAttribute("mssg", mssg);
		  }
		  else {
			  //Group by month and year
			  for (Compensation comp : compensations) {
					recordDate = comp.getDate();
					recordYear = recordDate.substring(0,4);
					recordMonth = recordDate.substring(5,7);
					
					//Case 0
					if(compensationsMonth.isEmpty() == true) {
						compensationsMonth.add(new CompensationOrg(recordMonth, monthText(recordMonth), recordYear, comp.getAmount()));
					}
					else {
						boolean add = false;
						for (CompensationOrg compensationOrg : compensationsMonth) {
							if(compensationOrg.getMonth().equals(recordMonth) && compensationOrg.getYear().equals(recordYear)) {
								//If there is another info in the same date, just add the amount
								compensationOrg.setAmount(compensationOrg.getAmount() + comp.getAmount());
							}
							else {
								add = true;
								break;
							}
						}
						if(add == true)
							//Adding the new info
							compensationsMonth.add(new CompensationOrg(recordMonth, monthText(recordMonth), recordYear, comp.getAmount()));
					}					
			  }
			  model.addAttribute("compensations", compensationsMonth);
		  }
		  model.addAttribute("employee", employee);
		  return "../compensationHistory";
	}
	
	public String monthText(String month) {
		switch(month) {
			case "01":
				month = "January";
			break;
			case "02":
				month = "February";
			break;
			case "03":
				month = "March";
			break;
			case "04":
				month = "April";
			break;
			case "05":
				month = "May";
			break;
			case "06":
				month = "June";
			break;
			case "07":
				month = "July";
			break;
			case "08":
				month = "August";
			break;
			case "09":
				month = "September";
			break;
			case "10":
				month = "October";
			break;
			case "11":
				month = "November";
			break;
			case "12":
				month = "December";
			break;	
			default:
				month = "-";
		}
		return month;
	}
	
	@RequestMapping(value = "/view-compensation-month/{key}", method = RequestMethod.GET)
	 public String viewCompensationMonth(@PathVariable("key") String key, ModelMap model, HttpServletRequest request) {
		
		String[] a = key.split(":");
		int id=Integer.parseInt(a[0]);
		Employee employee = service.viewEmployee(id);
		List<Compensation> compensations = cservice.getCompensationsEmployee(id);
		List<Compensation> compensationsMonth = new ArrayList<>();
		
		boolean records = compensations.isEmpty();
		String mssg = ""; 
		String recordDate, recordYear, recordMonth;
		String month = a[1];
		String year = a[2];
		float total = 0;
		
		if(records == true) {
		  mssg="0 results found";
		  model.addAttribute("mssg", mssg);
		}
		else {
			for (Compensation comp : compensations) {
				recordDate = comp.getDate();
				recordYear = recordDate.substring(0,4);
				recordMonth = recordDate.substring(5,7);
				
				if(recordYear.equals(year) && recordMonth.equals(month)) {
					compensationsMonth.add(comp);
					total += comp.getAmount();
				}
			}
		}
		
		records = compensationsMonth.isEmpty();
		if(records == true) {
			  mssg="0 results found";
			  model.addAttribute("mssg", mssg);
		}
		
		String monthText = monthText(month);
		
		model.addAttribute("employee", employee);
		model.addAttribute("compensations", compensationsMonth);
		model.addAttribute("month", month);
		model.addAttribute("monthText", monthText);
		model.addAttribute("year", year);
		model.addAttribute("total", total);
		return "../compensationMonth";
	}
	
	
	
	@RequestMapping(value="/addCompensation", method=RequestMethod.POST)
	public ModelAndView addCompensationStore(@ModelAttribute("compensation") Compensation compensation, HttpServletRequest request) throws ParseException {
		
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
	
	@RequestMapping(value="/editCompensation", method=RequestMethod.POST)
	public ModelAndView editCompensationStore(@ModelAttribute("compensation") Compensation compensation, HttpServletRequest request) throws ParseException {
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
		int id = Integer.parseInt(request.getParameter("id"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		String mssg = "";
		
		//COMPENSATION VALIDATION
		if (type.equals("Adjustment")) {
			//Check if the amount is different than zero
			if(amount == 0)
				mssg = "Amount can be any value except zero. ";
			//Check if there is a description
			if(description == "")
				mssg += "Description is required. ";
		}
		else if(type.equals("Allowance") || type.equals("Bonus") || type.equals("Commission")) {
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
				cservice.update(compensation, id);
				mv.setViewName("search");	
				mv.addObject("employees",employees);
				mv.addObject("mssg","The compensation was edited successfully!");
				
			}catch(Exception e) {
				
				mv.setViewName("editCompensation");	
				mv.addObject("mssg","Something went wrong please try again");
				mv.addObject("employee",employee);
				mv.addObject("compensation",compensation);
			}
		}
		else {
			mv.setViewName("editCompensation");	
			mv.addObject("mssg",mssg);
			mv.addObject("employee",employee);
			mv.addObject("compensation",compensation);
		}

		return mv;		
	}
}
