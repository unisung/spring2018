package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.springbook.biz.board.BoardVO;


public class BoardRowMapper implements RowMapper<BoardVO> {
	//쿼리결과와 객체를 매핑하는 메소드
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	   BoardVO vo = new BoardVO();
	   vo.setSeq(rs.getInt("SEQ"));
	   vo.setTitle(rs.getString("TITLE"));
	   vo.setWriter(rs.getString("WRITER"));
	   vo.setContent(rs.getString("CONTENT"));
	   vo.setRegdate(rs.getDate("REGDATE"));
	   vo.setCnt(rs.getInt("CNT"));
		
	   return vo;
	}

}
