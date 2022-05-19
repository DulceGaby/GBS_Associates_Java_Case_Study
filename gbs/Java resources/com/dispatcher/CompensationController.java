package com.dispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompensationController {
	
	@RequestMapping("/add-compensation")
	public String addCompensation() {
		 return "addCompensation";	
	}
	
	@RequestMapping("/view-compensation")
	public String viewCompensation() {
		 return "compensationHistory";
	}

}
