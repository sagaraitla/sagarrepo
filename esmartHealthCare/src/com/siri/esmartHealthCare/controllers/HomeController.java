package com.siri.esmartHealthCare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.siri.esmartHealthCare.beans.SignupBean;
import com.siri.esmartHealthCare.services.SignupServicesI;

@Controller
public class HomeController {
	@Autowired
	private SignupServicesI signupSer;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private JavaMailSender mailSender;
	
	String message = "";
	@RequestMapping(value = "/home")
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("getHome");
		return mav;
	}

	@RequestMapping(value = "/getDepartment")
	public ModelAndView getSignUpPage() {
		System.out.println("sign up is called...");
		SignupBean signup = new SignupBean();
		ModelAndView mav = new ModelAndView();
		
		List<String> listOfRoles = signupSer.getRoleList();
		
		
		
		mav.addObject("signup", signup);
		//mav.addObject("deptList", deptListOfNames);
		mav.addObject("roleList", listOfRoles);
		mav.setViewName("getSignup");
		return mav;
	}
	
	@RequestMapping(value="/signupPage",method=RequestMethod.POST)
	public ModelAndView signupPage(@ModelAttribute("signup") SignupBean signupBean){
		String msg = signupSer.saveDetails(signupBean);
		
			         
	       /* // prints debug info
	        System.out.println("To: " + signupBean.getEmail());
	        System.out.println("Subject: " + "subject");
	        System.out.println("Message: " + "message");
	         
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(signupBean.getEmail());
	        email.setSubject("subject");
	        email.setText("message");
	         
	        // sends the e-mail
	        mailSender.send(email);*/
		
		
		if(msg.equals("success")){
			message = "registration is successfully completed";
		}else{
			
			message = "registration is failed";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("success");
		
		return mav;
	}
	
	
	@RequestMapping(value="/getDeptDetails",method = RequestMethod.POST)	
	public @ResponseBody List<String> getDeptList(){
		List<String> deptListOfNames = null;
		try{
		System.out.println("getDeptDetails is called...");
		 deptListOfNames = signupSer.getDepList();
		System.out.println("size  "+deptListOfNames);
	//ModelAndView mav=new ModelAndView();
	//mav.setViewName("getSignup");
		for(String s: deptListOfNames){
			
	            System.out.println("Details---- : "+s);
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
	return deptListOfNames;
	}
	@RequestMapping(value="/login")
	public ModelAndView getLoginPage(){
	ModelAndView mav=new ModelAndView();
	mav.setViewName("login");
	return mav;
	}
}
