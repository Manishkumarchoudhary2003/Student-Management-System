package com.manish.springboot.myfirstwebapp.login;

import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("classname")
public class WelcomeController {

//	private AuthenticationService authenticationService;
//
//	public LoginController(AuthenticationService authenticationService) {
//		super();	
//		this.authenticationService = authenticationService;
//	}
	
	@RequestMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("classname", getLoggedinClassname(model));
		return "welcome";
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String gotoWelcomePage(ModelMap model) {
//		model.put("classname", getLoggedinClassname(model));
//		return "welcome";
//	}
	
//	private String getLoggedinclassname() {
//		
//		org.springframework.security.core.Authentication authentication	= 
//				SecurityContextHolder.getContext().getAuthentication();
//		
//		return authentication.getClassname();
//	}
	
	
	private String getLoggedinClassname(ModelMap model) {
	    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
	            .getAuthentication();

	    if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
	        org.springframework.security.core.userdetails.User user = 
	                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
	        
	        // Assuming the class name is a property in the User object
	        return user.getUsername();
	    }

	    return "DefaultClassName"; // Provide a default value or handle the error accordingly
	}

	
	

//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, 
//							@RequestParam String password, ModelMap model) {
//		if (authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			return "welcome";
//		}
//		model.put("errorMessage", "Invalid Credentials, PLease try again!");
//		return "login";
//
//	}

//	private Logger logger = LoggerFactory.getLogger(getClass());

//	@RequestMapping("login")
//	public String gotoLoginPage(@RequestParam int age, ModelMap model) {
//		model.put("age",age);
//		logger.debug("Request Param from Logger at debug level {}",age);
//		logger.info("Request Param from Logger at info level {}",age);
//		logger.warn("Request Param from Logger at warn level {}",age);
//		System.out.println("Request Params is : " + age);
//		return "login";
//	}

}
