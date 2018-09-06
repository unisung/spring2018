package com.springbook.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport {
   @Autowired
   public void setSuperDataSource(DataSource dataSource) {
	   super.setDataSource(dataSource);
   }
   
   //글 등록
   public void insertBoard(BoardVO vo) {
	   String sql = "insert into board(seq,title,writer,content)"
	   		          + " values((select nvl(max(seq),0)+1 from board),?,?,?)";
	   System.out.println("==> Spring JDBC로 insertBoard()기능 처리");
	   getJdbcTemplate().update(sql,vo.getTitle(),vo.getWriter(),vo.getContent());
   }
   
   public void updateBoard(BoardVO vo) {
	   String sql = "update board set title=?,content=? where seq=?";
	   System.out.println("==>Spring JDBC로 updateBoard()기능처리");
	   getJdbcTemplate().update(sql,vo.getTitle(),vo.getContent(),vo.getSeq());
	   
   }
   
   public void deleteBoard(BoardVO vo) {
	   String sql="delete from board where seq=?";
	   System.out.println("==>Spring JBC로 deleteBoard()기능처리");
	   getJdbcTemplate().update(sql,vo.getSeq());
	   
   }
	
   public BoardVO getBoard(BoardVO vo) {
	   String sql="select * from board where seq=?";
	  System.out.println("==>Spring JDBC로 getBoard()기능 처리");
	  Object[] args= {vo.getSeq()};
	  return getJdbcTemplate().queryForObject(sql, args, new BoardRowMapper());
	   
   }
   
   public List<BoardVO> getBoardList(BoardVO vo) {
	   String sql="select * from board order by seq";
	   System.out.println("==>Spring JDBC로 getBoardList()기능 처리");
	   return getJdbcTemplate().query(sql,new BoardRowMapper());
   }
   
   
   
   
}
