<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pUserId=request.getParameter("userId");
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select count(*) as count from member where id = ?";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, pUserId);
	rs=pstmt.executeQuery();
	int result=0;
	boolean isState=true;
	if(rs.next()){
		result=rs.getInt("count");
		if(result<=0){
			isState=true;
		} else {
			isState=false;
		}
	}
%>
{
	"isOk":<%= isState %>
}