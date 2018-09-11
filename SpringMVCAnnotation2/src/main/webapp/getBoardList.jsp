<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
  <h1>글목록</h1>
  <h3>
  	 <c:if test="${not empty user}">
  	    ${user.name}
  	 </c:if>
  	 <c:if test="${empty user}">
  	   guest   
  	 </c:if>
  	 님 환영합니다....
  	 <c:if test="${not empty user}">
  	 	<a href="logout.do">Log-out</a>
  	 </c:if>
  	 <c:if test="${empty user}">
  	 	<a href="login.jsp">Log-In</a>
  	 </c:if>
  </h3>
  <!-- 검색 시작 -->
  <form action="getBoardList.do" method="post">
    <table border="1" cellpadding="0" cellspacing="0" width="700">
    <tr>
    	<td align="right">
    	<select name="searchCondition">
    	  <c:forEach items="${conditionMap}" var="option">
    	     <option value="${option.value}">${option.key}
    	  </c:forEach>
      	</select>
    	<input type="text" name="searchKeyword">
    	<input type="submit" value="검색">
    	</td>
    </tr>
    </table>
  </form>
  <!-- 검색 종료 -->
  <table board="1" cellpadding="0" cellspacing="0" width="700">
  <tr>
  	<th bgcolor="orange" width="100">번호</th>
  	<th bgcolor="orange" width="200">제목</th>
  	<th bgcolor="orange" width="150">작성자</th>
  	<th bgcolor="orange" width="150">등록일</th>
  	<th bgcolor="orange" width="100">조회수</th>
  </tr>
  <c:forEach items="${boardList}" var="board">
  	<tr>
    <td>${board.seq }</td>
    <td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title }</td>
    <td>${board.writer}</td>
    <td>${board.regdate}</td>
    <td>${board.cnt}</td>
    </tr>
  </c:forEach>
  </table>
   <br>
   <a href="insertBoard.jsp">새글 등록</a>
</body>
</html>