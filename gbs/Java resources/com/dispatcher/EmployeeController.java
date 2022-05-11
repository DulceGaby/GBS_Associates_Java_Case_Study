package com.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
	
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployeeStore(HttpServletRequest request, HttpServletResponse responde) {
		System.out.println("ESTOY EN EL CONTROLADOR DE EMPLOYEE");
		String message ="";
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String birthDate = request.getParameter("birthDate");
		String position = request.getParameter("position");
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
		mv.addObject("mssg","The employee was added successfully !");
		return mv;
	}
}

