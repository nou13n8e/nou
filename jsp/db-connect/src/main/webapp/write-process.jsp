<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pUserName=request.getParameter("userName");;
	String pTitle=request.getParameter("title");
	String pContents=request.getParameter("contents");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String sql="insert into board values (seq_board.nextval, ?, ?, ?, sysdate, 0)";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, pUserName);
	pstmt.setString(2, pTitle);
	pstmt.setString(3, pContents);
	int result=pstmt.executeUpdate();
	if(result>0){
		response.sendRedirect("list.jsp");
	} else {
		out.println("<script>alert('작성 실패(서버 오류)'); history.back();</script>");
	}
	
	
%>