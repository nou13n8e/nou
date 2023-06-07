<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<%@ include file="include/footer.jsp" %>
<%
	//String userId=request.getParameter("userId");
	//16 변수를 선언한다고 해도 userId의 값을 받을 수 있는 방법이 없음
	//페이지가 바뀔 때 userId의 값을 받을 수 있게 직접 입력하는 방법 (login-ok.jsp?userId=)
	
	//String userId=(String)request.getAttribute("userId");
	//17 서버 내부적으로 전달되는 값이어서 오브젝트가 되기 때문에 String으로 타입 변환을 해줘야 함
	//페이지는 login-process인데 값은 login-ok에서 받아다가 사용함
	
	//String pageUserId=(String)pageContext.getAttribute("pageUserId");
	//18 pageContext는 해당 페이지를 벗어나면 작동하지 않음
	//String sessionUserId=(String)session.getAttribute("userId");
	//19 session은 끊기 전까지 작동함
%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>로그인 성공</p>
	<p><%= userId %>님, 안녕하세요.</p>
	<p><%= pageUserId %>님, 안녕하세요.</p>
	<p><%= sessionUserId %>님, 안녕하세요.</p>
</body>
</html> --%>