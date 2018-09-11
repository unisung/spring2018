package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController{
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

}
