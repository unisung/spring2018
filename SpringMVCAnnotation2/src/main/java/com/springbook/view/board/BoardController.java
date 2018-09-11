package com.springbook.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(vo.getSeq());
		System.out.println(vo.getTitle());
		
		boardDAO.deleteBoard(vo);

		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO board, BoardDAO dao, Model model) {
		board = dao.getBoard(board);
		
		System.out.println("board.getSeq()="+board.getSeq());
		//session에 객체 저장
        model.addAttribute("board",board);
		System.out.println("content 여기까지");
	
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			//request.getParameter("searchCondition")
			@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
			@RequestParam(value="searchKeyword" ,defaultValue="",required=false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
		    vo.setSearchCondition(condition);
		    vo.setSearchKeyword(keyword);
		
		   System.out.println("검색조건:"+condition);
		   System.out.println("검색 단어:"+keyword);
		   
		  List<BoardVO> boardList = boardDAO.getBoardList(vo);
		  model.addAttribute("boardList", boardList);
		 
		 return "getBoardList.jsp";//view명 설정
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}

	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO dao) {
		
		dao.updateBoard(vo);
		
		 return "getBoardList.do";
	}

	 //검색 조건 목록 설정
	 @ModelAttribute("conditionMap")
	 public Map<String,String> searchConditionMap(){
		 Map<String,String> conditionMap = new HashMap<>();
		 conditionMap.put("제목", "TITLE");
		 conditionMap.put("내용", "CONTENT");
		 
		 return conditionMap;
	 }
}
