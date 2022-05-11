package com.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse responde ) {
		String message ="";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Check if it is a correct email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == false) {
        	message ="The email entered is invalid.";
            System.out.println("The email entered is invalid.");
        } 
        if(!password.equals("IBM2022")) {
        	message += " Incorrect password.";
        	System.out.println("Incorrect password.");
        } 
        
        ModelAndView mv = new ModelAndView();
        
        //If there are problems in the form, it will be redirected to the login again, with a message
        if(message!="") {
        	System.out.println("There is a message");
        	mv.setViewName("index.jsp");
        	mv.addObject("mssg",message);
        	mv.addObject("emailE",email);
        	return mv;
        }
		
		mv.setViewName("home.jsp");	
		return mv;
	}
}

