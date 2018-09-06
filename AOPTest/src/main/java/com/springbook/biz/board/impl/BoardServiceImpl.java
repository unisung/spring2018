package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
/*@Component("boardService")*/
public class BoardServiceImpl implements BoardService {
    //bean중에서 boardDAO로 된 객체를 찾아서 자동으로 주입 어노테이션
	@Autowired
	private BoardDAO boardDAO;
	 
	@Override
	public void insertBoard(BoardVO vo) {
     boardDAO.insertBoard(vo);

	}

	@Override
	public void updatBoard(BoardVO vo) {
    boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) throws Exception {
		if(vo.getSeq()==1) {
		 throw new Exception("1번글이 존재하지 않습니다.");
		}
		 boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
