package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	  
		String searchCondition 
	    = request.getParameter("searchCondition");
		
	if(searchCondition==null || searchCondition.length()==0)
			searchCondition="";
	
	  String searchKeyword
	    =request.getParameter("searchKeyword");

	  if(searchKeyword==null||searchKeyword.length()==0) {
		  searchKeyword="";
	  }
	  
	  BoardVO vo = new BoardVO();
	  vo.setSearchCondition(searchCondition);
	  vo.setSearchKeyword(searchKeyword);
	  
	  BoardDAO boardDAO = new BoardDAO();
	  List<BoardVO> boardList = boardDAO.getBoardList(vo);
	  HttpSession session = request.getSession();
	  
	  session.setAttribute("boardList", boardList);
	  
		/*return "getBoardList";*/
	  
	  ModelAndView mav = new ModelAndView();
	  mav.addObject("boardList", boardList);
	  mav.setViewName("getBoardList");
	  
	  return mav;
	}

}
