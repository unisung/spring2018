package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class UpdateBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String seq = request.getParameter("seq");
	    
	    BoardVO vo = new BoardVO();
	    vo.setTitle(title);
	    vo.setContent(content);
	    vo.setSeq(Integer.parseInt(seq));
	    
	    BoardDAO dao = new BoardDAO();
	    dao.updateBoard(vo);
	    
		
		return "getBoardList.do";
	}

}
