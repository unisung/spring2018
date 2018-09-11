package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String seq = request.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		board.setSeq(Integer.parseInt(seq));
		board = dao.getBoard(board);
		
		//session에 객체 저장
		HttpSession session= request.getSession();
		session.setAttribute("board",board);
		
		//이동 페이지
		/*return "getBoard";*/
		return new ModelAndView();
	}

}
