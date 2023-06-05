<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from member where id = ? and password = ?";

	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	
	rs = pstmt.executeQuery();
	while(rs.next()){
		String _userId=rs.getString("id");
		String _userName=rs.getString("name");
		String _userPw=rs.getString("password");
		System.out.println(_userId+"="+_userName+"="+_userPw);
	}
	
	//System.out.println(conn);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>