package com.manish.springboot.myfirstwebapp.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class sayHelloController {
		
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHTML() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("Hello, I am Choudhary");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHello() {
		return "sayHello";
	}


}
