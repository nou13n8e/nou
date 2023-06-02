<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
  String name="장선영";
  String msg="hello";
%>
<!-- 상단에 변수 선언할 때는 %!를 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello jsp</h1>
	<h2><%= name %></h2>
	<!-- html태그 안에서 변수를 출력할 때는 %=을 사용 -->
	<%
		out.println("hello jsp");
		out.println(name);
		for(int i=0; i<100; i++){
			out.println("hello jsp <br>");
		}
	%>
</body>
</html>