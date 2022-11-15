package com.javassem.exeception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.javassem")
public class ProjectExceptionHandler {
	
	@ExceptionHandler
	public String handleException(Exception e, Model m) {
		
		m.addAttribute("exception",e);
		
		return "error/TransErrorPage";
	}

}
