<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	//session의 값 삭제
	response.sendRedirect("login-form.jsp");
	//보낼 정보가 없다면 sendRedirect 사용 <> history.back();
%>