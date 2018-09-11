package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller  {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	 
		//브라우저와 연결된 session 객체 종료
		HttpSession session = request.getSession();
	 session.invalidate();
	 
	  //이동할 화면 
		//return "login";// ./login.jsp
	 ModelAndView mav = new ModelAndView();
	 mav.setViewName("redirect:login.jsp");
	 
	 return mav;
		
	}

}
