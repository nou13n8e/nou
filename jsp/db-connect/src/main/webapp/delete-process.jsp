<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userId=(String) session.getAttribute("loggedUserId");
	String userPw=(String) request.getParameter("userPw");

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="delete from member where id=? and password=?";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, userId);
	pstmt.setString(2, userPw);
	int result=pstmt.executeUpdate();
	if(result>0){
		session.invalidate();
		//session의 값 삭제
		response.sendRedirect("login-form.jsp");
		//보낼 정보가 없다면 response.sendRedirect 사용 <> history.back();
	} else {
		out.println("<script>alert('회원탈퇴 실패(서버 오류)'); history.back();</script>");
	}
%>