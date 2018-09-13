package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
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
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody//body만 json으로 변경
	public List<BoardVO> dataTransForm(
			//request.getParameter("searchCondition")
			@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
			@RequestParam(value="searchKeyword" ,defaultValue="",required=false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
		    vo.setSearchCondition(condition);
		    vo.setSearchKeyword(keyword);
		
		   System.out.println("검색조건:"+condition);
		   System.out.println("검색 단어:"+keyword);
		   
		  List<BoardVO> boardList = boardDAO.getBoardList(vo);
		 
		 
		 return boardList;//조회한 객체를 리턴
	}
	
	@RequestMapping("/dataTransform2.do")
	@ResponseBody//body만 xml로 변경
	public BoardListVO dataTransform2(
			//request.getParameter("searchCondition")
			@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
			@RequestParam(value="searchKeyword" ,defaultValue="",required=false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
		    vo.setSearchCondition(condition);
		    vo.setSearchKeyword(keyword);
		
		   System.out.println("검색조건:"+condition);
		   System.out.println("검색 단어:"+keyword);
		   
		  List<BoardVO> boardList = boardDAO.getBoardList(vo);
		  BoardListVO boardListVO = new BoardListVO();
		  boardListVO.setBoardList(boardList);
		 
		   
		 return boardListVO;//XML파일 리턴
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
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IllegalStateException, IOException {
		String path = "C:\\springWorkspace\\SpringMVCFileUpload01\\src\\main\\webapp\\images\\";     
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName=uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(path+fileName));
			vo.setFilename(fileName);
		}
		
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}

	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO dao) throws IllegalStateException, IOException {
		String path = "C:\\springWorkspace\\SpringMVCFileUpload01\\src\\main\\webapp\\images\\";     
		//파일 업로드 처리
				MultipartFile uploadFile = vo.getUploadFile();
				System.out.println(10/0);
			/*	uploadFile=null;
				
				System.out.println(uploadFile);
				*/
				System.out.println(vo.getUploadFile().getOriginalFilename());
		     if(!uploadFile.isEmpty()) {
					String fileName=uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File(path+fileName));
					vo.setFilename(fileName);
				}
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
