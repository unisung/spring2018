package com.springbook.biz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   public HelloServlet() {
	   System.out.println("helloSevlet 객체 생성");
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().append(request.getContextPath()).append(" doGet() 메소드 호출");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
