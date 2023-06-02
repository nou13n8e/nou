<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId=request.getParameter("userId");
	String userPw=request.getParameter("userPw");
	String isLogin="";
	if(userId.equals("nou") && userPw.equals("1234")){
		isLogin="로그인 성공";
	} else {
		isLogin="로그인 실패";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= isLogin %></h1>
</body>
</html>