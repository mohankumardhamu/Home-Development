package com.codeMantra.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codeMantra.model.*;

@Controller
public class UserController {
	
	public static int userID;
	
	@RequestMapping(value="/timeSheet", method=RequestMethod.GET)
	public String showHome(Model model) {
		model.addAttribute("User",new User());
		return "WEB-INF/Home";
	}
	
	@RequestMapping(value="/timeSheet", method=RequestMethod.POST)
	public String postLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("User") User user) {
		ModelAndView mav =  new ModelAndView("User");
		mav.addObject("User",new User());
		
		
		Date date = user.getDate();
		String startTime = user.getStartTime();
		String endTime = user.getEndTime();
		String projectName = user.getProjectName();
		String taskName = user.getTaskName();
		
		if(date.toString().length() >0)
		{
			
		}
		
		return "WEB-INF/Home";
	}
}
