package com.codeMantra.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codeMantra.model.*;

import com.codeMantra.dao.*;

@Controller
public class LoginController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =  new ModelAndView("Login");
		mav.addObject("Login",new Login());
		return mav;
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String postLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("Login") Login login) {
		ModelAndView mav =  new ModelAndView();
		String name=login.getUsername();  
		//System.out.println("Username :: " +name);
		String password=login.getPassword();
		//System.out.println(password);
		
		UserDaoImpl udi = new UserDaoImpl(name, password);
		boolean userExist = udi.CheckUser();
		
		if(userExist)
		{
			return "WEB-INF/Home";
		}
		else
		{
			return "Login";
		}
	}
}