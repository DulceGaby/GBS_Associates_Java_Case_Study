package com.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse responde ) {
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
		int r = i+j;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("result",r);
		
		
		return mv;
	}
}

