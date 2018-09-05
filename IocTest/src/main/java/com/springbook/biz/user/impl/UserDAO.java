package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springbook.biz.commom.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Component("userDAO")
public class UserDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public UserVO getUser(UserVO vo) {
		 String sql = "select * from users where id=?";
			try {
	    	     conn = JDBCUtil.getConnection();
	    	     pstmt = conn.prepareStatement(sql);
	    	     pstmt.setString(1, vo.getId());
	    	     rs =pstmt.executeQuery();
	    	     if(rs.next()) {	 
	    	    	 vo.setId(rs.getString(1));
	    	    	 vo.setName(rs.getString(3));
	    	    	 vo.setPassword(rs.getString(2));
	    	    	 vo.setRole(rs.getString(4));
	    	     }
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 JDBCUtil.close(rs,pstmt, conn);
	     }
		return vo;
	}
	//회원등록
	public void insertUser(UserVO vo) {
      String sql = "insert into users(id,name,password,role) values(?,?,?,?)";
		try {
    	     conn = JDBCUtil.getConnection();
    	     pstmt = conn.prepareStatement(sql);
    	     pstmt.setString(1, vo.getId());
    	     pstmt.setString(2, vo.getName());
    	     pstmt.setString(3, vo.getPassword());
    	     pstmt.setString(4, vo.getRole());
    	     pstmt.executeUpdate();
     }catch(Exception e) {
    	 e.printStackTrace();
     }finally {
    	 JDBCUtil.close(pstmt, conn);
     }
		
	}
	public List<UserVO> getUserList(UserVO vo) {
		List<UserVO> list= new ArrayList<>();
		  String sql = "select * from users order by id";
			try {
	    	     conn = JDBCUtil.getConnection();
	    	     pstmt = conn.prepareStatement(sql);
	    	     rs =pstmt.executeQuery();
	    	     while(rs.next()) {
	                 vo = new UserVO();
	    	    	 
	                 vo.setId(rs.getString(1));
	    	    	 vo.setName(rs.getString(3));
	    	    	 vo.setPassword(rs.getString(2));
	    	    	 vo.setRole(rs.getString(4));
	    	    	 
	    	    	 list.add(vo);
	    	     }
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 JDBCUtil.close(rs,pstmt, conn);
	     }
		return list;
	}
	
	public void updateUser(UserVO vo) {
		String sql = "update users set password=?,role=? where id=?";
		try {
    	     conn = JDBCUtil.getConnection();
    	     pstmt = conn.prepareStatement(sql);
    	     pstmt.setString(3, vo.getId());
    	     pstmt.setString(1, vo.getPassword());
    	     pstmt.setString(2, vo.getRole());
    	     pstmt.executeUpdate();
     }catch(Exception e) {
    	 e.printStackTrace();
     }finally {
    	 JDBCUtil.close(pstmt, conn);
     }
	}//updateUser()메소드 끝.
	
	
public void deleteUser(UserVO vo) {
	String sql = "delete from users where id=?";
		try {
    	     conn = JDBCUtil.getConnection();
    	     conn.setAutoCommit(false);
    	     pstmt = conn.prepareStatement(sql);
    	     pstmt.setString(1, vo.getId());
    	     pstmt.executeUpdate();
    	     conn.commit();
     }catch(Exception e) {
    	 try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	 e.printStackTrace();
     }finally {
    	  try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {	e.printStackTrace();
		}
    	 JDBCUtil.close(pstmt, conn);
     }		
}
	
	

}
