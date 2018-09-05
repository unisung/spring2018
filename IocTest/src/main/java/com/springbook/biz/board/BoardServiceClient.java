package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
	 //1.스프링 컨테이너 구동
		ApplicationContext ac
		  =new GenericXmlApplicationContext("applicationContext.xml");
	 //2.컨테이너로 부터 객체를 가져옴
		BoardService boardService =
				     (BoardService)ac.getBean("boardService");
	 //3.글 등록 처리
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용......");
		boardService.insertBoard(vo);
		System.out.println("등록 처리 완료");
		
	 //4.글 목록  
		List<BoardVO>list =  boardService.getBoardList(new BoardVO());
		for(BoardVO l:list) {
			System.out.println(l.toString());
		}
		
	 //5. 내용보기
	 vo.setSeq(list.size());
	 vo = boardService.getBoard(vo);
    System.out.println((list.size())+"번 글 내용 보기");
    System.out.println(vo.toString());
	  
     //6. 수정하기
     vo.setTitle("임시제목-수정");
     vo.setContent("임시 내용 - 수정");
     vo.setSeq(1);
      //수정
      boardService.updatBoard(vo);
     
      list =  boardService.getBoardList(new BoardVO());
      //수정된 리스트 보기
      for(BoardVO l:list) {
			System.out.println(l.toString());
		}
      
     //7.삭제하기
      vo.setSeq(1);
      boardService.deleteBoard(vo);
      
      list =  boardService.getBoardList(new BoardVO());
      //삭제 후 리스트 보기
      for(BoardVO l:list) {
			System.out.println(l.toString());
		}
    
	}

}
