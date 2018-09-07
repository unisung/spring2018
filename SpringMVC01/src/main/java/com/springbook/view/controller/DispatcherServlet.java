package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
  
    
	@Override
	public void init() throws ServletException {
      handlerMapping = new HandlerMapping();
      viewResolver = new ViewResolver();
      viewResolver.setPrefix("./");
      viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		
	String uri = request.getRequestURI();
	String path = uri.substring(uri.lastIndexOf("/"));
	
	System.out.println("uri="+uri);
	System.out.println("path="+path);
	
	Controller controller = handlerMapping.getController(path);
	String viewName = controller.handleRequest(request, response);
	
	String view =null;
	
	if(!viewName.contains(".do")) {
		view=viewResolver.getView(viewName);
	}else {
		view=viewName;
	}
   
	//이동할 객체를 session에 저장함.(-redirect를 해도 객체를 읽을 수 있음)
	response.sendRedirect(view);//"getBoardList.do"
	
	}

}
