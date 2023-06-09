<%@page import="com.nou.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp"%>
<%
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from board";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	rs=pstmt.executeQuery();
	
	ArrayList<BoardDto> boardList=new ArrayList<>();
	//반복문 돌린 값을 배열에 집어넣기
	
	while(rs.next()){
		BoardDto boardDto=new BoardDto();
		boardDto.setId(rs.getInt("id"));
		boardDto.setName(rs.getString("name"));
		boardDto.setTitle(rs.getString("title"));
		boardDto.setContents(rs.getString("contents"));
		boardDto.setDate(rs.getString("regdate"));
		boardDto.setHit(rs.getInt("hit"));
		boardList.add(boardDto);
		
	}

%>
<div class="container">
	<ul>
		<li>
			<span>1</span>
			<span>제목</span>
			<span>가나다</span>
			<span>2023/06/09</span>
			<span>0</span>
			
		</li>
	</ul>
</div>
<%@ include file = "include/footer.jsp"%>