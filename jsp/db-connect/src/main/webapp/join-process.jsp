<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	String pUserName=request.getParameter("userName");
	int pUserZonecode=Integer.parseInt(request.getParameter("zonecode"));
	String pUserAddress=request.getParameter("userAddress");
	String pUserDetailAddress=request.getParameter("detailAddress");
	String pUserExtraAddress=request.getParameter("extraAddress");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="insert into member values(?,?,?,?,?,?,?)";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserName);
	pstmt.setString(3, pUserPw);
	pstmt.setInt(4, pUserZonecode);
	pstmt.setString(5, pUserAddress);
	pstmt.setString(6, pUserDetailAddress);
	pstmt.setString(7, pUserExtraAddress);
	int result=pstmt.executeUpdate();
	if(result>0){
		response.sendRedirect("login-form.jsp");
	} else {
		out.println("<script>alert('회원가입 실패(서버 오류)'); history.back();</script>");
	}
	
	
%>