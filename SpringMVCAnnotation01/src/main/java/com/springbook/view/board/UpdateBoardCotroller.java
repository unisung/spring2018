package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardCotroller {
	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		
		dao.updateBoard(vo);
		
		 return "getBoardList.do";
	}

}
