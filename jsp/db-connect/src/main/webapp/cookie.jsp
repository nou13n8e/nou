<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie01 = new Cookie("myCookie01","초코칩");
	cookie01.setPath(request.getContextPath());
	//cookie01을 setPath를 이용해 request.getContextPath로 내려보내주기
	cookie01.setMaxAge(60);
	//setMaxAge로 얼마 뒤 값을 삭제할 것인지 설정(60초*60분*24시간)
	response.addCookie(cookie01);
	//값을 받아오므로 response를 사용, addCookie로 쿠키를 내려보내기
	
	Cookie cookie02 = new Cookie("myCookie02","아몬드");
	cookie02.setPath(request.getContextPath());
	cookie02.setMaxAge(60);
	response.addCookie(cookie02);

	System.out.println(request.getContextPath());
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