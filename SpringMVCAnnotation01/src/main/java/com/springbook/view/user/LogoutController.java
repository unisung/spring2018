package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{

 @RequestMapping("/logout.do")
	public String handleRequest(HttpServletRequest request) {
	 
		//브라우저와 연결된 session 객체 종료
		HttpSession session = request.getSession();
	     session.invalidate();
	 
	  
	 return "login.jsp";
		
	}

}
