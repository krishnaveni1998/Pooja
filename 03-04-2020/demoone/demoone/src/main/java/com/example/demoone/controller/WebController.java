package com.example.demoone.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.LoginForm;


@Controller
public class WebController {
	@RequestMapping(value="/loginform" )
	public String welcomeLogin() {
	//	return new ModelAndView("login","loginForm", new LoginForm());
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("LoginForm") LoginForm loginForm,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		boolean status=false;
		if(loginForm.getPassword().equals("123")) {
			status=true;
		}
		mv.addObject("status", ((status==true)? "Success" : "Failed"  ));
		mv.addObject("username", loginForm.getUsername());
		mv.setViewName("LoginStatus");
		return mv;
		
	}
	
	   @RequestMapping(value="/logout",method = RequestMethod.GET)
	   public String logOut(HttpSession session,HttpServletResponse                 
	   response,HttpServletRequest request) throws IOException{
	    return "redirect:/loginform";
	   }

	/*@PostMapping("/destroy")
	public ModelAndView destroySession(HttpServletRequest request) {
		try {
			System.out.println("session:"+request.getSession());
		request.getSession().invalidate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
*/
}
