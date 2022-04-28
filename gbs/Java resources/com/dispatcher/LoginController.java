package com.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse responde ) {
		System.out.println("ESTOY EN EL CONTROLADOR DE LOGIN");
		int email = Integer.parseInt(request.getParameter("email"));
		int password = Integer.parseInt(request.getParameter("password"));
		int r = 5555;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("result",r);
		
		
		return mv;
	}
}
