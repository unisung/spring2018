package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	//CRUD 기능 메소드
	//글 등록
	void insertBoard(BoardVO vo);
	//글 수정
	void updatBoard(BoardVO vo);
	//글 삭제
	void deleteBoard(BoardVO vo);
	//글 내용 보기
	BoardVO getBoard(BoardVO vo);
	//글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);

}
