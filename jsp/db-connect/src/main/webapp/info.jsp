<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<!-- prettier-ignore -->
<%
	String ploggedUserId=(String)session.getAttribute("loggedUserId");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="nou";
	String pw="0080";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select id,name,email,address,zonecode,lpad(zonecode,5,'0') as changeZonecode,detailAddress from member where id=?";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, ploggedUserId);
	rs=pstmt.executeQuery();
	String address=null;
	String detailAddress=null;
	String zonecode=null;
	String name=null;
	String email=null;
	if(rs.next()){
		address=rs.getString("address");
		detailAddress=rs.getString("detailAddress");
		zonecode=rs.getString("changeZonecode");
		name=rs.getString("name");
		email=rs.getString("email");
	}
	if(detailAddress==null){
		detailAddress = "";
	}
%>
<div class="container-sm mt-5">
  <table class="table">
    <tbody>
      <tr>
        <th scope="row">ID</th>
        <td><%= ploggedUserId  %></td>
      </tr>
      <tr>
        <th scope="row">Name</th>
        <td><%= name %></td>
      </tr>
            <tr>
        <th scope="row">E-mail</th>
        <td><%= email %></td>
      </tr>
      <tr>
        <th scope="row">Address</th>
        <td><%= address +" "+ detailAddress %></td>
      </tr>
      <tr>
        <th scope="row">Code</th>
        <td><%= zonecode %></td>
      </tr>
    </tbody>
  </table>
  <div class="mt-5">
    <a href="modify.jsp" class="btn btn-primary">회원 정보 수정</a>
    <a href="modify-password.jsp" class="btn btn-primary">비밀번호 변경</a>
    <a href="delete.jsp" class="btn btn-danger">회원 탈퇴</a>
  </div>
</div>
<%@ include file="include/footer.jsp" %>
