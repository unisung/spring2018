package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.commom.JDBCUtil;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

@Repository("boardDAO")//Dao용도 어노테이션
/*@Component("boardDAO")*/
//BoardDAO는 POJO(Plain Old Java Object:단순 자바객체)
public class BoardDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	//글등록
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board(seq,title,writer,content) "
				       + " values((select nvl(max(seq),0)+1 from board),?,?,?)";
		try{
			  conn = JDBCUtil.getConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1,vo.getTitle());
			  pstmt.setString(2, vo.getWriter());
			  pstmt.setString(3, vo.getContent());
			  pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//내용수정
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?,content=? where seq=?";
	try{
		  conn = JDBCUtil.getConnection();
		  pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1,vo.getTitle());
		  pstmt.setString(2, vo.getContent());
		  pstmt.setInt(3, vo.getSeq());
		  pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(pstmt, conn);
	}
		
	}
	//삭제 처리
	public void deleteBoard(BoardVO vo) {
		String sql = "delete from board where seq=?";
		try{
			  conn = JDBCUtil.getConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, vo.getSeq());
			  pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//내용보기
	public BoardVO getBoard(BoardVO vo) {
	 try {
		 	//조회수 증가
		    updateBoardViewCount(vo);
		    //내용보기 처리
		    String sql = "select * from board where seq=?";
		     conn=JDBCUtil.getConnection();
		     pstmt = conn.prepareStatement(sql);
		     pstmt.setInt(1, vo.getSeq());
		     rs = pstmt.executeQuery();
		     if(rs.next()) {
		    	 vo.setTitle(rs.getString(2));
		    	 vo.setWriter(rs.getString(3));
		    	 vo.setContent(rs.getString(4));
		    	 vo.setRegdate(rs.getDate(5));
		    	 vo.setCnt(rs.getInt(6));
		     }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 JDBCUtil.close(rs,pstmt,conn);
	 }
		return vo;
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list =new ArrayList<>();
		System.out.println("searchCondition="+vo.getSearchCondition());
		try {
			    String sql = "select * from board ";
			  
			   if(vo.getSearchCondition().equals("TITLE")) {
			       sql = sql + " where title like ? ";	
			    }else if(vo.getSearchCondition().equals("content")) {
			      sql = sql + " where content like ?";
			    }
			    
			     sql = sql+" order by seq";
			     
			     System.out.println("sql="+sql);
			     
			     conn = JDBCUtil.getConnection();
			     pstmt = conn.prepareStatement(sql);
			     
			    if(vo.getSearchCondition().equals("TITLE")) {
				      pstmt.setString(1, "%"+vo.getSearchKeyword()+"%");
				    }else if(vo.getSearchCondition().equals("content")) {
				      pstmt.setString(1, "%"+vo.getSearchKeyword()+"%");
				    }
			     
			     rs = pstmt.executeQuery();
			     
			     while(rs.next()) {
			    	 BoardVO vo1 = new BoardVO();
			    	 
			    	 vo1.setSeq(rs.getInt(1));
			    	 vo1.setTitle(rs.getString(2));
			    	 vo1.setWriter(rs.getString(3));
			    	 vo1.setContent(rs.getString(4));
			    	 vo1.setRegdate(rs.getDate(5));
			    	 vo1.setCnt(rs.getInt(6));
			    	 
			    	 list.add(vo1);
			     }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,pstmt,conn);
		}
		return list;
	}
	
	  //조회수 증가
		public void updateBoardViewCount(BoardVO vo) {
			String sql = "update board set cnt = cnt+1 where seq=?";
		try{
			  conn = JDBCUtil.getConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, vo.getSeq());
			  pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
			
		}//updateBoardViewCount()메소드 끝.
}
