<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookies[]=request.getCookies();
	//쿠키는 몇 개가 있을지 모르므로 배열로 반환되고, 클라이언트가 서버에 보내는 정보이므로 request 사용
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			//쿠키에는 String 타입만 사용 가능
			String cookieName=cookies[i].getName();
			String cookieValue=cookies[i].getValue();
			out.println(cookieName+"==="+cookieValue);
		}
	}
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