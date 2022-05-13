package com.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< Updated upstream
=======
import com.dto.Employee;
import com.services.EmployeeService;

>>>>>>> Stashed changes

@Controller
public class EmployeeController {
	
	@RequestMapping("/add-employee")
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse responde) {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("home.jsp");	
		 return mv;
	}
	
	@RequestMapping("/add-compensation")
	public ModelAndView addCompensation(HttpServletRequest request, HttpServletResponse responde) {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("addCompensation.jsp");	
		 return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView employees(HttpServletRequest request, HttpServletResponse responde) {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("search.jsp");	
		 return mv;
	}
	
<<<<<<< Updated upstream
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployeeStore(HttpServletRequest request, HttpServletResponse responde) {
=======
	@Autowired
	private EmployeeService service;
	
	
	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

//	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
//	public ModelAndView addEmployeeStore(@ModelAttribute("employee") Employee employee) {
//		System.out.println("ESTOY EN EL CONTROLADOR DE EMPLOYEE");
//		String message ="";
//		System.out.println(employee);
////		String firstName = request.getParameter("firstName");
////		String middleName = request.getParameter("middleName");
////		String lastName = request.getParameter("lastName");
////		String birthDate = request.getParameter("birthDate");
////		String position = request.getParameter("position");
////		
////        
//        ModelAndView mv = new ModelAndView();
//        
//		mv.setViewName("search.jsp");	
//		mv.addObject("mssg","The employee was added successfully !");
//		return mv;
//	}
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public ModelAndView addEmployeeStore(@ModelAttribute("employee") Employee employee) {
>>>>>>> Stashed changes
		System.out.println("ESTOY EN EL CONTROLADOR DE EMPLOYEE");
		int result = service.save(employee);
		
		
		String message ="";
<<<<<<< Updated upstream
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String birthDate = request.getParameter("birthDate");
		String position = request.getParameter("position");
=======
//		String firstName = request.getParameter("firstName");
//		String middleName = request.getParameter("middleName");
//		String lastName = request.getParameter("lastName");
//		String birthDate = request.getParameter("birthDate");
//		String position = request.getParameter("position");
>>>>>>> Stashed changes
//		
//		// Check if it is a correct email
//        Pattern pattern = Pattern
//                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
// 
//        Matcher mather = pattern.matcher(email);
// 
//        if (mather.find() == false) {
//        	message ="The email entered is invalid.";
//            System.out.println("The email entered is invalid.");
//        } 
//        if(!password.equals("IBM2022")) {
//        	message += " Incorrect password.";
//        	System.out.println("Incorrect password.");
//        } 
//        
        ModelAndView mv = new ModelAndView();
//        
//        //If there are problems in the form, it will be redirected to the login again, with a message
//        if(message!="") {
//        	System.out.println("There is a message");
//        	mv.setViewName("index.jsp");
//        	mv.addObject("mssg",message);
//        	mv.addObject("emailE",email);
//        	return mv;
//        }
//		
//        If everything it's ok, then redirect to the search view with the successfull mssg
        
		mv.setViewName("search.jsp");	
		mv.addObject("mssg","The employee was added successfully !"+result);
		return mv;
	}
}

