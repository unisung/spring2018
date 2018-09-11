package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController  {
	
	@RequestMapping("/insertBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}

}
