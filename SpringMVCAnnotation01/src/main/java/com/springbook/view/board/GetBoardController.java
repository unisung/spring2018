package com.springbook.view.board;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public String handleRequest(BoardVO board, BoardDAO dao, Model model) {
		board = dao.getBoard(board);
		
		System.out.println("board.getSeq()="+board.getSeq());
		//session에 객체 저장
        model.addAttribute("board",board);
		System.out.println("content 여기까지");
		//이동 페이지
		/*return "getBoard";*/
		return "getBoard.jsp";
	}

}
